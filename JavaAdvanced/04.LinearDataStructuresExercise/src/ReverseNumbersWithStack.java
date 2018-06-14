import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        fillStack(stack, tokens);
        printReversed(stack);
    }
    
    private static void printReversed(ArrayDeque<Integer> stack) {
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
    }

    private static void fillStack(ArrayDeque<Integer> stack, String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            stack.push(Integer.parseInt(tokens[i]));
        }
    }
}
