import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = Double.parseDouble(scanner.nextLine());
        double pricePerKg = 1.20;

        BigDecimal priceInLv = new BigDecimal(quantity * pricePerKg);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInMarks = exchangeRate.multiply(priceInLv);
        System.out.printf("%.2f marks", priceInMarks);
    }
}
