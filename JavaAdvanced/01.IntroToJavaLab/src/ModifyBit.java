import java.util.Scanner;

public class ModifyBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int newBitValue = scanner.nextInt();

        /*
        if (newBitValue == 0) {
            int mask = ~(1 << position);
            int result = number & mask;
            System.out.println(result);
        } else if (newBitValue == 1) {
            int mask = 1 << position;
            int result = number | mask;
            System.out.println(result);
        }
        */
        int mask = 1 << position;
        System.out.println((number & ~mask) | ((newBitValue << position) & mask));
    }
}
