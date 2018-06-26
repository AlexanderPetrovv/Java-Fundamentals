import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new ArrayDeque<>();
        int storageGoldCnt = 0;

        Integer[] stones = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(queue, stones);

        String line;
        while (!"Revision".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String operation = tokens[0] + " " + tokens[1];
            int amount = Integer.parseInt(tokens[2]);

            if ("Apply acid".equals(operation)) {
                while (amount > 0) {
                    if (queue.isEmpty()) {
                        break;
                    }
                    int currentStone = queue.poll();
                    currentStone--;
                    if (currentStone == 0) {
                        storageGoldCnt++;
                    } else {
                        queue.add(currentStone);
                    }
                    amount--;
                }
            } else {
                if (storageGoldCnt <= 0) {
                    continue;
                }
                storageGoldCnt--;
                queue.add(amount);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer stone : queue) {
            sb.append(stone).append(" ");
        }
        sb.append(System.lineSeparator()).append(storageGoldCnt);
        System.out.println(sb.toString());
    }
}
