import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];
        fillMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;

        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                int currentSum = getCurrentSum(matrix, r, c);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = r;
                    colIndex = c;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printSumMatrix(matrix, rowIndex, colIndex);
    }

    private static void printSumMatrix(int[][] matrix, int startRow, int startCol) {
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (j != startCol) {
                    System.out.print(" " + matrix[i][j]);
                    continue;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int getCurrentSum(int[][] matrix, int r, int c) {
        // 3 by 3 matrix sum
        int sum = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            String[] lineTokens = scanner.nextLine().split(" ");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = Integer.parseInt(lineTokens[c]);
            }
        }
    }
}
