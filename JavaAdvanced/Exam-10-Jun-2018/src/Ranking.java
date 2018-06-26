import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ranking {
    private static final String TERMINATE_CONDITION_FIRST = "end of contests";
    private static final String TERMINATE_CONDITION_SECOND = "end of submissions";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // map of contest = password
        Map<String, String> contestsData = new HashMap<>();

        String line = reader.readLine();
        while (!TERMINATE_CONDITION_FIRST.equals(line)) {
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contestsData.putIfAbsent(contest, password);
            line = reader.readLine();
        }

        // map of username -> contests = points
        Map<String, Map<String, Integer>> usersData = new TreeMap<>();

        line = reader.readLine();
        while (!TERMINATE_CONDITION_SECOND.equals(line)) {
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contestsData.containsKey(contest) && contestsData.get(contest).equals(password)) {
                if (!usersData.containsKey(username)) {
                    usersData.put(username, new LinkedHashMap<>());
                }

                if (!usersData.get(username).containsKey(contest)) {
                    usersData.get(username).put(contest, points);
                }
                int oldValue = usersData.get(username).get(contest);
                if (oldValue < points) {
                    usersData.get(username).put(contest, points);
                }
            }
            line = reader.readLine();
        }

        usersData.entrySet().stream()
                .sorted((user1, user2) -> {
                    int totalScore1 = user1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int totalScore2 = user2.getValue().values().stream().mapToInt(Integer::intValue).sum();

                    return totalScore2 - totalScore1;
                })
                .limit(1)
                .forEach(u -> System.out.println(String.format("Best candidate is %s with total %d points.",
                        u.getKey(), u.getValue().values().stream().mapToInt(Integer::intValue).sum())));

        System.out.println("Ranking:");
        usersData.entrySet().stream()
                .forEach((user) -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(user.getKey()).append(System.lineSeparator());

                    user.getValue().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(c -> sb.append(String.format("#  %s -> %d", c.getKey(), c.getValue()))
                                    .append(System.lineSeparator()));
                    System.out.print(sb.toString());
                });
    }
}
