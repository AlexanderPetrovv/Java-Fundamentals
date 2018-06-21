import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TakeTwoStream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        Arrays.stream(tokens)
                .map(x -> Integer.parseInt(x))
                .filter(x -> 10 <= x && x <= 20)
                .distinct()
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
