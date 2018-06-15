import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> aggregator = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] lineTokens = scanner.nextLine().split(" ");
            String ip = lineTokens[0];
            String name = lineTokens[1];
            int duration = Integer.parseInt(lineTokens[2]);

            if (!aggregator.containsKey(name)) {
                aggregator.put(name, new TreeMap<>());
            }
            if (!aggregator.get(name).containsKey(ip)) {
                aggregator.get(name).put(ip, 0);
            }
            int oldValue = aggregator.get(name).get(ip);
            aggregator.get(name).put(ip, oldValue + duration);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : aggregator.entrySet()) {
            String name = entry.getKey();
            int totalDuration = 0;
            for (int duration : aggregator.get(name).values()) {
                totalDuration += duration;
            }
            System.out.print(name + ": " + totalDuration + " ");
            System.out.println(aggregator.get(name).keySet());
        }
    }
}
