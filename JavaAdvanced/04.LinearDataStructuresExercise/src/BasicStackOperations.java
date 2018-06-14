import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLineTokens = scanner.nextLine().split(" ");
        int elementsToPush = Integer.parseInt(firstLineTokens[0]);
        int elementsToPop = Integer.parseInt(firstLineTokens[1]);
        int targetElement = Integer.parseInt(firstLineTokens[2]);

        String[] secondLineTokens = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Push elements to stack
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(Integer.parseInt(secondLineTokens[i]));
        }

        // Pop elements from stack - Last In, First Out
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        // Check if present
        boolean isPresent = stack.contains(targetElement);
        if (isPresent) {
            System.out.println(true);
        } else {
            int minElement = getMinElement(stack);
            System.out.println(minElement);
        }
    }

    private static int getMinElement(ArrayDeque<Integer> stack) {
        int minValue = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer < minValue) {
                minValue = integer;
            }
        }
        return minValue;
    }
}
