import java.util.Arrays;
import java.util.Scanner;

public class matrixMul {
    static int[][] MATRIX_MULT(int[][] A, int[][] B) {
        int rows_A = A.length;
        int cols_A = A[0].length;
        int rows_B = B.length;
        int cols_B = B[0].length;
        if(cols_A != rows_B) {
            throw new Error("Matrix multiplication is not defined.");
        }

        int[][] result = new int[rows_A][cols_B];
        for(int i = 0; i < rows_A; i++) {
            for(int j = 0; j < cols_B; j++) {
                result[i][j] = 0;
            }
        }

        for(int i = 0; i < rows_A; i++) {
            for(int j = 0; j < cols_B; j++) {
                int sum = 0;
                for(int k = 0; k < cols_A; k++) {
                    sum = sum + (A[i][k] * B[k][j]);
                    result[i][j] = sum;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] A = new int[2][3];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("Enter Integer: ");
                A[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(A));

        int[][] B = new int[3][2];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print("Enter Integer: ");
                B[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(B));

        int[][] result = MATRIX_MULT(A,B);
        System.out.println(Arrays.deepToString(result));
    }
}
