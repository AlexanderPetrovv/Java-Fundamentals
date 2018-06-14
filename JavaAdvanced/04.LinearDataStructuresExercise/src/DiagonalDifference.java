import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        fillMatrix(scanner, n, matrix);

        int primaryDiagSum = 0;
        int secondaryDiagSum = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagSum += matrix[i][i];
            secondaryDiagSum += matrix[i][n - i - 1];
        }

        System.out.println(Math.abs(primaryDiagSum - secondaryDiagSum));
    }

    private static void fillMatrix(Scanner scanner, int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            String[] lineTokens = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(lineTokens[j]);
            }
        }
    }
}
