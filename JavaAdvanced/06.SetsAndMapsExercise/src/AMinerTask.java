import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> minerDict = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"stop".equals(line)) {
            String resource = line;
            long quantity = Integer.parseInt(scanner.nextLine());
            if (!minerDict.containsKey(resource)) {
                minerDict.put(resource, 0L);
            }
            minerDict.put(resource, minerDict.get(resource) + quantity);
            line = scanner.nextLine();
        }

        for (String s : minerDict.keySet()) {
            System.out.println(s + " -> " + minerDict.get(s));
        }
    }
}
