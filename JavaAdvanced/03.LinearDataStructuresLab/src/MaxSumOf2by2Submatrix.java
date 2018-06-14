import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSumOf2by2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int currentSum = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = r;
                    colIndex = c;
                }
            }
        }

        printSubmatrix(matrix, rowIndex, colIndex);
        System.out.println(maxSum);
    }

    private static int[][] fillMatrix(Scanner scanner) {
        List<String> dimensions = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int rows = Integer.parseInt(dimensions.get(0));
        int cols = Integer.parseInt(dimensions.get(1));
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(inputTokens[j]);
            }
        }
        return matrix;
    }

    private static void printSubmatrix(int[][] matrix, int rowIndex, int colIndex) {
        for (int i = rowIndex; i < rowIndex + 2; i++) {
            for (int j = colIndex; j < colIndex + 2; j++) {
                if (j == colIndex) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
