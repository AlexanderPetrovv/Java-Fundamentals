import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] range = reader.readLine().split(" ");
        int startRange = Integer.parseInt(range[0]);
        int endRange = Integer.parseInt(range[1]);
        String oddEven = reader.readLine();
        Predicate<Integer> oddOrEven = getOddOrEven(oddEven);
        for (int i = startRange; i <= endRange; i++) {
            if (oddOrEven.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> getOddOrEven(String oddEven) {
        if ("odd".equals(oddEven)) {
            return x -> x % 2 != 0;
        } else {
            return x -> x % 2 == 0;
        }
    }
}
