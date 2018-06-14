import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(inputTokens[0]);
        int cols = Integer.parseInt(inputTokens[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(scanner, matrix);

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] lineTokens = line.split(" ");

            if (lineTokens.length == 5 && "swap".equals(lineTokens[0])) {
                int firstRowIndex = Integer.parseInt(lineTokens[1]);
                int firstColIndex = Integer.parseInt(lineTokens[2]);
                int secondRowIndex = Integer.parseInt(lineTokens[3]);
                int secondColIndex = Integer.parseInt(lineTokens[4]);

                if (isValidCell(matrix, firstRowIndex, firstColIndex)
                        && isValidCell(matrix, secondRowIndex, secondColIndex)) {
                    String temp = matrix[firstRowIndex][firstColIndex];
                    matrix[firstRowIndex][firstColIndex] = matrix[secondRowIndex][secondColIndex];
                    matrix[secondRowIndex][secondColIndex] = temp;
                    printMatrix(matrix);
                } else {
                    printInvalidMessage();
                    continue;
                }
            } else {
                printInvalidMessage();
                continue;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != 0) {
                    System.out.print(" " + matrix[i][j]);
                    continue;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void printInvalidMessage() {
        System.out.println("Invalid input!");
    }

    private static boolean isValidCell(String[][] matrix, int r, int c) {
        return (r >= 0 && r < matrix.length) && (c >= 0 && c < matrix[r].length);
    }


    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            String[] lineTokens = scanner.nextLine().split(" ");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = lineTokens[c];
            }
        }
    }
}
