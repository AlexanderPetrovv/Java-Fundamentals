import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {
    private static Map<Integer, Long> memory = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Memorization technique

        int wantedFibNum = Integer.parseInt(scanner.nextLine());
        long nthFibNumber = getFib(wantedFibNum);
        System.out.println(nthFibNumber);
    }

    private static long getFib(int n) {
        if (n <= 1) {
            return 1;
            // or return n for f(0) = 0, f(1) = 1, f(2) = 1 etc.
        }
        if (memory.containsKey(n)){
            return memory.get(n);
        }
        long value = getFib(n - 1) + getFib(n - 2);
        memory.put(n, value);
        return value;
    }
}
