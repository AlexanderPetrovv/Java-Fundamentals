import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read the points coordinates
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        scanner.nextLine();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        scanner.nextLine();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        // calculate the area using the given points
        double area = Math.abs((x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)) / 2);
        System.out.println((int)area);
    }
}
