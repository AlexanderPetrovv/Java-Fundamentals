import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(", ");

        if (numbers.length < 2) {
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + numbers[0]);
        } else {
            Function<String, Integer> parser = n -> Integer.parseInt(n);
            int sum = 0;
            for (String number : numbers) {
                sum += parser.apply(number);
            }
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + sum);
        }
    }
}
