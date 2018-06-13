import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());
        String[] matrixTokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixTokens[0]);
        int cols = Integer.parseInt(matrixTokens[1]);

        long[][] matrix = new long[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = scanner.nextLong();
            }
            scanner.nextLine();
        }

        String[] blurPixelTokens = scanner.nextLine().split("\\s+");
        int blurPixelRow = Integer.parseInt(blurPixelTokens[0]);
        int blurPixelCol = Integer.parseInt(blurPixelTokens[1]);

        int startRowIndex = Math.max(0, blurPixelRow - 1);
        int startColIndex = Math.max(0, blurPixelCol - 1);
        int endRowIndex = Math.min(matrix.length - 1, blurPixelRow + 1);
        int endColIndex = Math.min(matrix[0].length - 1, blurPixelCol + 1);

        for (int r = startRowIndex; r <= endRowIndex; r++) {
            for (int c = startColIndex; c <= endColIndex; c++) {
                matrix[r][c] += blurAmount;
            }
        }
        
        printMatrix(matrix);
    }
    
    private static void printMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    System.out.print(matrix[i][j]);
                    continue;
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
