import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] coordinates = reader.readLine().split(" ");
        int n = Integer.parseInt(coordinates[0]);
        int m = Integer.parseInt(coordinates[1]);

        int[][] matrix = new int[n][m];

        String line = reader.readLine();
        while (!"Here We Go".equals(line)) {
            String[] tokens = line.split(" ");
            int x1 = Integer.parseInt(tokens[0]);
            int y1 = Integer.parseInt(tokens[1]);
            int x2 = Integer.parseInt(tokens[2]);
            int y2 = Integer.parseInt(tokens[3]);

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    matrix[i][j] += 1;
                }
            }
            line = reader.readLine();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
