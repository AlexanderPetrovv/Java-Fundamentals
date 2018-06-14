import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parentheses = scanner.nextLine().split("");
        if (areBalanced(parentheses)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean areBalanced(String[] parentheses) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length; i++) {
            if ("{".equals(parentheses[i]) || "(".equals(parentheses[i]) || "[".equals(parentheses[i])) {
                stack.push(parentheses[i]);
            }

            if ("}".equals(parentheses[i]) || ")".equals(parentheses[i]) || "]".equals(parentheses[i])) {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(stack.pop(), parentheses[i])) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(String par1, String par2) {
        if ("(".equals(par1) && ")".equals(par2)) {
            return true;
        } else if ("{".equals(par1) && "}".equals(par2)) {
            return true;
        } else if ("[".equals(par1) && "]".equals(par2)) {
            return true;
        } else {
            return false;
        }
    }
}
