import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        Consumer<Integer> printNums = n -> System.out.print(n + " ");

        String command = reader.readLine();
        while (!"end".equals(command)) {
            if ("print".equals(command)) {
                for (Integer number : numbers) {
                    printNums.accept(number);
                }
                System.out.println();
            } else {
                Function<Integer, Integer> applyFunc = getFunction(command);
                for (int i = 0; i < numbers.size(); i++) {
                    numbers.set(i, applyFunc.apply(numbers.get(i)));
                }
            }
            command = reader.readLine();
        }
    }

    private static Function<Integer,Integer> getFunction(String command) {
        if ("add".equals(command)) {
            return x -> x + 1;
        } else if ("subtract".equals(command)) {
            return x -> x - 1;
        } else {// multiply
            return x -> x * 2;
        }
    }
}
