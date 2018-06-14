import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //List<String> tokens = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String[] matrixTokens = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixTokens[0]);
        int cols = Integer.parseInt(matrixTokens[1]);
        int[][] matrix = new int[rows][cols];


        int sum = 0;
        for (int r = 0; r < rows; r++) {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(inputTokens[c]);
                sum += matrix[r][c];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
