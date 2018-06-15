import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> records = new TreeMap<>();
        String line = scanner.nextLine();
        while(!"end".equals(line)) {
            String[] lineTokens = line.split(" ");
            String ip = lineTokens[0].substring(3);
            String username = lineTokens[2].substring(5);

            if (!records.containsKey(username)) {
                records.put(username, new LinkedHashMap<>());
            }

            if (!records.get(username).containsKey(ip)) {
                records.get(username).put(ip, 0);
            }
            int oldValue = records.get(username).get(ip);
            records.get(username).put(ip, oldValue + 1);

            line = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> userEntry : records.entrySet()) {
            System.out.println(userEntry.getKey() + ":");
            boolean isFirstIp = true;
            for (Map.Entry<String, Integer> ipEntry : userEntry.getValue().entrySet()) {
                if (!isFirstIp) {
                    System.out.print(", ");
                }
                System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue());
                isFirstIp = false;
            }
            System.out.println(".");
        }
    }
}
