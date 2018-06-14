import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(inputTokens[0]);
        String pattern = inputTokens[1];

        int[][] matrix = new int[n][n];
        switch (pattern) {
            case "A":
                fillWithPatternA(matrix);
                break;
            case "B":
                fillWithPatternB(matrix);
                break;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void fillWithPatternA(int[][] matrix) {
        int cnt = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = cnt++;
            }
        }
    }

    private static void fillWithPatternB(int[][] matrix) {
        int cnt = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = cnt++;
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0 ; j--) {
                    matrix[j][i] = cnt++;
                }
            }

        }
    }
}
