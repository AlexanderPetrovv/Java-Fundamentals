import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = Double.parseDouble(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double taxiRate = 0.79;
        if ("night".equals(dayTime)) {
            taxiRate = 0.9;
        }

        double price;
        if (distance < 20) {
            price = 0.7 + taxiRate * distance;
        } else if (distance < 100) {
            price = 0.09 * distance;
        } else {
            price = 0.06 * distance;
        }
        System.out.printf("%.2f", price);
    }
}
