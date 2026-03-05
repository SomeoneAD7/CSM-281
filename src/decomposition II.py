import numpy as np

# =====================================================================
# MATRIX DEFINITIONS
# =====================================================================
A = np.array([[4, 2, 2, 0],
              [2, 5, 1, 2],
              [2, 1, 5, 2],
              [0, 2, 2, 6]], dtype=float)

B = np.array([[1, 0],
              [1, 1],
              [0, 1]], dtype=float)

b = np.array([8, 10, 10, 10], dtype=float)   # RHS for Ax = b
c = np.array([1,  2,  0],  dtype=float)       # RHS for Bx = c

# =====================================================================
# PART A.1: CHOLESKY DECOMPOSITION  (from scratch)
# =====================================================================
def cholesky(A):
    n = A.shape[0]
    R = np.zeros_like(A)
    for i in range(n):                          # row index
        # Diagonal entry
        s = A[i, i] - np.sum(R[:i, i]**2)
        if s <= 0:
            raise ValueError('Matrix is not SPD!')
        R[i, i] = np.sqrt(s)
        # Off-diagonal entries (to the right)
        for j in range(i+1, n):
            R[i,j] = (A[i,j] - np.dot(R[:i,i], R[:i,j])) / R[i,i]
    return R

R_chol = cholesky(A)
print("=" * 60)
print("PART A.1 — CHOLESKY DECOMPOSITION")
print("=" * 60)
print("\nCholesky Factor R:")
print(np.round(R_chol, 4))
print("\nR^T (lower triangular):")
print(np.round(R_chol.T, 4))
print("\nVerify R^T @ R == A:", np.allclose(R_chol.T @ R_chol, A))


def forward_sub(L, b):
    """Solve Ly = b where L is lower-triangular (forward substitution)."""
    n = len(b)
    y = np.zeros(n)
    for i in range(n):
        y[i] = (b[i] - np.dot(L[i, :i], y[:i])) / L[i, i]
    return y


def backward_sub(U, y):
    """Solve Ux = y where U is upper-triangular (backward substitution)."""
    n = len(y)
    x = np.zeros(n)
    for i in range(n-1, -1, -1):
        x[i] = (y[i] - np.dot(U[i, i+1:], x[i+1:])) / U[i, i]
    return x


y_sol = forward_sub(R_chol.T, b)     # Step 1: Solve R^T y = b
x_sol = backward_sub(R_chol, y_sol)  # Step 2: Solve R x = y

print("\nIntermediate vector y (from R^T y = b):", np.round(y_sol, 4))
print("Solution x (Cholesky):                  ", np.round(x_sol, 4))
print("Verify A @ x == b:                      ", np.allclose(A @ x_sol, b))

# Compare with numpy's built-in solver
x_np = np.linalg.solve(A, b)
print("NumPy built-in solution:                ", np.round(x_np, 4))


# =====================================================================
# PART A.2 & A.3: GRAM-SCHMIDT + QR DECOMPOSITION (from scratch)
# =====================================================================
def gram_schmidt_qr(B):
    """
    Compute QR decomposition via the Gram-Schmidt process.
    Returns Q (orthonormal columns) and R (upper triangular).
    """
    m, n = B.shape
    Q = np.zeros((m, n))
    R = np.zeros((n, n))
    for j in range(n):             # process each column
        v = B[:, j].copy()         # start with the original column
        for i in range(j):         # subtract projections onto q_0 .. q_{j-1}
            R[i, j] = np.dot(Q[:, i], B[:, j])   # projection coefficient
            v -= R[i, j] * Q[:, i]               # remove that component
        R[j, j] = np.linalg.norm(v)  # diagonal = norm of remaining vector
        Q[:, j] = v / R[j, j]        # normalise to get unit vector
    return Q, R


print("\n" + "=" * 60)
print("PART A.2 — GRAM-SCHMIDT ORTHONORMALISATION")
print("=" * 60)

Q_gs, R_gs = gram_schmidt_qr(B)

print("\nOrthonormal vector q1:", np.round(Q_gs[:, 0], 4))
print("Orthonormal vector q2:", np.round(Q_gs[:, 1], 4))
print("\nVerify ||q1|| = 1:", np.isclose(np.linalg.norm(Q_gs[:, 0]), 1))
print("Verify ||q2|| = 1:", np.isclose(np.linalg.norm(Q_gs[:, 1]), 1))
print("Verify q1 . q2 = 0:", np.isclose(np.dot(Q_gs[:, 0], Q_gs[:, 1]), 0))

print("\n" + "=" * 60)
print("PART A.3 — QR DECOMPOSITION")
print("=" * 60)
print("\nMatrix Q (orthonormal columns):")
print(np.round(Q_gs, 4))
print("\nMatrix R (upper triangular):")
print(np.round(R_gs, 4))
print("\nVerify Q @ R == B:     ", np.allclose(Q_gs @ R_gs, B))
print("Verify Q^T @ Q == I:   ", np.allclose(Q_gs.T @ Q_gs, np.eye(2)))

# Solve Bx = c (least-squares via QR)
print("\n--- Solving Bx = c (least-squares) ---")
QTc = Q_gs.T @ c                  # Compute Q^T c
print("Q^T c:", np.round(QTc, 4))
x_ls = backward_sub(R_gs, QTc)   # Solve R x = Q^T c
print("Least-squares solution x:", np.round(x_ls, 4))

# Verify
residual = B @ x_ls - c
print("Residual r = Bx - c:    ", np.round(residual, 4))
print("B^T @ r (should be ~0): ", np.round(B.T @ residual, 4))
print("Residual norm:          ", np.round(np.linalg.norm(residual), 4))

# Compare with numpy
x_lstsq = np.linalg.lstsq(B, c, rcond=None)[0]
print("NumPy lstsq solution:   ", np.round(x_lstsq, 4))

# Compare with numpy's built-in QR
print("\n--- NumPy built-in QR (for comparison) ---")
Q_np, R_np = np.linalg.qr(B)
print("NumPy Q:\n", np.round(Q_np, 4))
print("NumPy R:\n", np.round(R_np, 4)) 
