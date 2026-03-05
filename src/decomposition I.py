import numpy as np

# -----------------------------
# 1. Define Matrix A and Vector b
# -----------------------------
A = np.array([
    [2, -1, 1, 2],
    [4,  1, 0, 3],
    [-2, 2, 5, -1],
    [6,  0, 3, 4]
], dtype=float)

b = np.array([5, 6, 4, 10], dtype=float)

print("Matrix A:\n", A)
print("\nVector b:\n", b)

# -----------------------------
# 2. Solve Ax = b using NumPy
# -----------------------------
x = np.linalg.solve(A, b)

print("\nComputed Solution x:")
print(x)

# -----------------------------
# 3. Residual Check (Ax - b)
# -----------------------------
residual = A @ x - b

print("\nResidual (Ax - b):")
print(residual)

# -----------------------------
# 4. Define P, L, U from Part A
# -----------------------------

# Permutation Matrix P
# (Row1 <-> Row4, Row2 <-> Row3)
P = np.array([
    [0, 0, 0, 1],
    [0, 0, 1, 0],
    [0, 1, 0, 0],
    [1, 0, 0, 0]
], dtype=float)

# L matrix
L = np.array([
    [1,     0,    0,   0],
    [-1/3,  1,    0,   0],
    [2/3,  1/2,   1,   0],
    [1/3, -1/2,  1/4,  1]
], dtype=float)

# U matrix
U = np.array([
    [6, 0, 3, 4],
    [0, 2, 6, 1/3],
    [0, 0, -5, 1/6],
    [0, 0, 0, 3/2]
], dtype=float)

# -----------------------------
# 5. Verify PA = LU
# -----------------------------
PA = P @ A
LU = L @ U

print("\nPA matrix:")
print(PA)

print("\nLU matrix:")
print(LU)

print("\nDifference (PA - LU):")
print(PA - LU)

# -----------------------------
# 6. Final Conclusion
# -----------------------------
if np.allclose(PA, LU):
    print("\nVerification Successful: PA = LU")
else:
    print("\nVerification Failed!")

if np.allclose(residual, np.zeros(4)):
    print("Residual is zero: Solution is correct.")
else:
    print("Residual is not zero: Check calculations.")

