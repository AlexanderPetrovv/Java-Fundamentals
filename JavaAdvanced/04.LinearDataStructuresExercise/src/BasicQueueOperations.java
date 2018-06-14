import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int elementsToAdd = Integer.parseInt(tokens[0]);
        int elementsToRemove = Integer.parseInt(tokens[1]);
        int targetElement = Integer.parseInt(tokens[2]);

        String[] numsAsStr = scanner.nextLine().split(" ");
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Push elements to queue
        for (int i = 0; i < elementsToAdd; i++) {
            queue.offer(Integer.parseInt(numsAsStr[i]));
        }

        // Remove from queue - First In, First Out
        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        // Check for element
        boolean isPresent = queue.contains(targetElement);
        if (isPresent) {
            System.out.println(true);
        } else {
            int minElement = getMinElement(queue);
            System.out.println(minElement);
        }
    }

    private static int getMinElement(ArrayDeque<Integer> queue) {
        int minValue = Integer.MAX_VALUE;
        for (Integer integer : queue) {
            if (integer < minValue) {
                minValue = integer;
            }
        }
        return minValue;
    }
}
