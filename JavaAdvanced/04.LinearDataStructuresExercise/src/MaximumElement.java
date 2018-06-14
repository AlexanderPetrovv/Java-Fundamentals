import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] commandTokens = br.readLine().split(" ");
            switch (commandTokens[0]) {
                case "1":
                    int numToPush = Integer.parseInt(commandTokens[1]);
                    stack.push(numToPush);
                    if (maxElement <= numToPush) {
                        maxElement = numToPush;
                        maxStack.push(maxElement);
                    }
                    break;
                case "2":
                    if (stack.pop() == maxElement) {
                        maxStack.pop();
                        if (maxStack.size() > 0) {
                            maxElement = maxStack.peek();
                        } else {
                            maxElement = Integer.MIN_VALUE;
                        }
                    }
                    break;
                case "3":
                    builder.append(maxElement).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(builder);
    }
}
