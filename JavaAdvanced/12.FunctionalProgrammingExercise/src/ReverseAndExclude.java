import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divisor = Integer.parseInt(reader.readLine());

        Function<List<Integer>, List<Integer>> reverseIntArr = arr -> {
            List<Integer> reversedArr = new ArrayList<>();
            for (int i = arr.size() - 1; i >= 0; i--) {
                reversedArr.add(arr.get(i));
            }
            return reversedArr;
        };

        List<Integer> reversedNumbers = reverseIntArr.apply(numbers);
        Predicate<Integer> isDivisible = x -> x % divisor == 0;
        for (int i = 0; i < reversedNumbers.size(); i++) {
            if (isDivisible.test(reversedNumbers.get(i))) {
                reversedNumbers.remove(reversedNumbers.get(i));
                i--;
            }
        }

        Consumer<Integer> print = x -> System.out.print(x + " ");
        for (Integer number : reversedNumbers) {
            print.accept(number);
        }
    }
}
