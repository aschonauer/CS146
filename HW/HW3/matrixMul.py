def MATRIX_MULTIPLY(A, B):
    result = []
    rows_A = len(A)
    cols_A = len(A[0])
    rows_B = len(B)
    cols_B = len(B[0])

    if cols_A != rows_B:
        raise ValueError("Matrix multiplication not defined")

    for i in range(rows_A):
        row = []
        for j in range(cols_B):
            row.append(0)
        result.append(row)

    for i in range(rows_A):
        for j in range(cols_B):
            sum = 0
            for k in range(cols_A):
                sum = sum + (A[i][k] * B[k][j])
                result[i][j] = sum

    return result


A = [[1, 0],
     [2, 3],
     [4, 5]]

B = [[1, 3, 2],
     [3, 4, 8]]

result = MATRIX_MULTIPLY(A, B)
print(result)
