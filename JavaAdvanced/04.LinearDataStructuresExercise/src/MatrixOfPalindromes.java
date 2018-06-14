import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(inputTokens[0]);
        int cols = Integer.parseInt(inputTokens[1]);

        String[][] matrix = new String[rows][cols];

        generateMatrix(matrix);
        printMatrix(matrix);
    }

    private static void generateMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char firstLetter = (char)(97 + r);
                char secondLetter = (char)(97 + r + c);
                char thirdLetter = (char)(97 + r);
                matrix[r][c] = Character.toString(firstLetter) +
                        Character.toString(secondLetter) +
                        Character.toString(thirdLetter);
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] aMatrix : matrix) {
            for (int j = 0; j < aMatrix.length; j++) {
                if (j == 0) {
                    System.out.print(aMatrix[j]);
                } else {
                    System.out.print(" " + aMatrix[j]);
                }
            }
            System.out.println();
        }
    }
}
