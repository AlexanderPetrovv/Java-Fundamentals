import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // solution without streams
        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));
        Set<Integer> numbers = new LinkedHashSet<>();
        for (String token : tokens) {
            if (numbers.size() >= 2) {
                break;
            }

            if (10 <= Integer.valueOf(token) && Integer.valueOf(token) <= 20) {
                numbers.add(Integer.valueOf(token));
            }
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
