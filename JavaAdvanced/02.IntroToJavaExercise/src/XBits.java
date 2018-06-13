import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[8][32];
        for (int i = 0; i < matrix.length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            char[] chars = Integer.toBinaryString(number).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int index = matrix[i].length - chars.length + j;
                matrix[i][index] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        int validXbitsCnt = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                if (matrix[i][j] == 1 && isValidXbit(matrix, i, j)) {
                    validXbitsCnt++;
                }
            }
        }
        System.out.println(validXbitsCnt);
    }

    private static boolean isValidXbit(int[][] matrix, int row, int col) {
        int[] pattern = { 1, 0, 1, 0, 1, 0, 1, 0 ,1 };
        int currentIndex = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (pattern[currentIndex++] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
