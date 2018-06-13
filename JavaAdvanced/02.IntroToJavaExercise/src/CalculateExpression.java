import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double a = Double.parseDouble(tokens[0]);
        double b = Double.parseDouble(tokens[1]);
        double c = Double.parseDouble(tokens[2]);

        double f1Result = calculateFirstFormula(a, b, c);
        double f2Result = calculateSecondFormula(a, b, c);

        double diff = Math.abs(((a + b + c) / 3) - (f1Result + f2Result) / 2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1Result, f2Result, diff);
    }

    public static double calculateFirstFormula(double a, double b, double c) {
        return Math.pow((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2)),(a + b + c) / Math.sqrt(c));
    }

    public static double calculateSecondFormula(double a, double b, double c) {
        return Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), (a - b));
    }
}
