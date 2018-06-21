import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class AverageOfDouble {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble avg = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .mapToDouble(x -> Double.parseDouble(x))
                .average();

        if (avg.isPresent()) {
            System.out.printf("%.2f%n", avg.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
