import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isInteger = x -> {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(0) == '+' || x.charAt(0) == '-') {
                    continue;
                }

                if (!Character.isDigit(x.charAt(i))) {
                    return false;
                }
            }
            return true;
        };

        Optional<Integer> sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .filter(isInteger)
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }
}
