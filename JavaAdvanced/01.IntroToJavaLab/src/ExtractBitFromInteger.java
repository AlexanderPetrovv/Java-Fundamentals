import java.util.Scanner;

public class ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int bitIndex = scanner.nextInt();

        int maskRight = num >> bitIndex;
        int bit = maskRight & 1;
        System.out.println(bit);
    }
}
