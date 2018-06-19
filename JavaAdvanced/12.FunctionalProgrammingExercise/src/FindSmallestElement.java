import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> indexMinElement = arr -> {
            int minVal = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) <= minVal) {
                    minVal = arr.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };

        int index = indexMinElement.apply(numbers);
        System.out.println(index);
    }
}
