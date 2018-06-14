import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, players);

        int cycle = 1;
        while(queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle < 2) return false;
        if (cycle == 2) return true;
        if (cycle % 2 == 0) return false;
        for (int i = 3; i * i <= cycle ; i += 2) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
