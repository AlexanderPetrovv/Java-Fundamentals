import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        if (numbers.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numbers.length; i += 2) {
            int currentNum = Integer.parseInt(numbers[i]);
            int nextNum = Integer.parseInt(numbers[i + 1]);

            if (currentNum % 2 == 0 && nextNum % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n", currentNum, nextNum);
            } else if (currentNum % 2 != 0 && nextNum % 2 != 0) {
                System.out.printf("%d, %d -> both are odd%n", currentNum, nextNum);
            } else {
                System.out.printf("%d, %d -> different%n", currentNum, nextNum);
            }
        }
    }
}
