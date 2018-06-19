import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        // or HashSet of Integers
        int[] divisors = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> hasDivisors = (num) -> {
            for (int divisor : divisors) {
                if (num % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hasDivisors.test(i)) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
