import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int temp = n;
        int m = scanner.nextInt();
        BigInteger product = BigInteger.ONE;
        do {
            BigInteger num = new BigInteger("" + n);
            product = product.multiply(num);
            n++;
        } while(n <= m);

        System.out.printf("product[%d..%d] = %d%n", temp, m, product);
    }
}
