import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) {
        String path = "./resources/input.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            long sum = 0;
            for (String line : lines) {
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
