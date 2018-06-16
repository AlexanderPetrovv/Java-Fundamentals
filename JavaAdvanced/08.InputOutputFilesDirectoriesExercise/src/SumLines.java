import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String path = "./resources/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null) {
                long sum = 0;
                char[] chars = line.toCharArray();
                for (char ch : chars) {
                    sum += ch;
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
