import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble num = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> x.length() > 0)
                .mapToDouble(Double::parseDouble)
                .filter(x -> x % 2 == 0)
                .min();

        if (num.isPresent()) {
            System.out.printf("%.2f%n", num.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
