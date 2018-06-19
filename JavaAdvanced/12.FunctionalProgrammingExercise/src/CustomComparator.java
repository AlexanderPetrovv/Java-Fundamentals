import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        Integer[] inputNums = new Integer[input.length];
        // Integer[] numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for (int i = 0; i < input.length; i++) {
            inputNums[i] = Integer.parseInt(input[i]);
        }

        Comparator<Integer> compareEvensOdds = (firstNum, secondNum) -> {
            boolean firstIsEven = firstNum % 2 == 0;
            boolean secondIsEven = secondNum % 2 == 0;

            if (firstIsEven && !secondIsEven) {
                return -1;
            } else if (!firstIsEven && secondIsEven) {
                return 1;
            } else {
                return firstNum - secondNum;
            }
        };

        Arrays.sort(inputNums, compareEvensOdds);
        StringBuilder sb = new StringBuilder();
        for (Integer inputNum : inputNums) {
            sb.append(inputNum).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
