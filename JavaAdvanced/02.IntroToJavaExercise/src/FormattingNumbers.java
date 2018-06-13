import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int a = Integer.parseInt(tokens[0]);
        double b = Double.parseDouble(tokens[1]);
        double c = Double.parseDouble(tokens[2]);

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|",
                Integer.toHexString(a).toUpperCase(),
                String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0"),
                b,
                c);
    }
}
