import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = "(.*?) @(.*?) (\\d+) (\\d+)";
        Map<String, Map<String, Long>> concertsData = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            Pattern p = Pattern.compile(pattern);
            Matcher match = p.matcher(line);
            if (match.find()) {
                String singerName = match.group(1);
                String venueName = match.group(2);
                long tickedPrice = Integer.parseInt(match.group(3));
                long ticketCount = Integer.parseInt(match.group(4));
                long totalMoney = tickedPrice * ticketCount;

                if (!concertsData.containsKey(venueName)) {
                    concertsData.put(venueName, new LinkedHashMap<>());
                }
                if (!concertsData.get(venueName).containsKey(singerName)) {
                    concertsData.get(venueName).put(singerName, 0L);
                }
                concertsData.get(venueName).put(singerName, concertsData.get(venueName).get(singerName) + totalMoney);
            }
            line = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Long>> concert : concertsData.entrySet()) {
            System.out.println(concert.getKey());
            Map<String, Long> sortedSingers = concertsData.get(concert.getKey()).entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            for (Map.Entry<String, Long> singer : sortedSingers.entrySet()) {
                System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue());
            }
        }
    }
}
