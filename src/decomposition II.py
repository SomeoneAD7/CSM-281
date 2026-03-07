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
    for i in range(n):  # row index
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

print(""" """) 

