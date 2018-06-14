import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalInt = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalInt == 0) {
            System.out.println(decimalInt);
        } else {
            while(decimalInt != 0) {
                stack.push(decimalInt % 2);
                decimalInt /= 2;
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
