import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(?<home>[a-zA-Z ]+)\\s+-\\s+(?<away>[a-zA-Z ]+)\\s+result\\s+(?<homeScore>\\d+):(?<awayScore>\\d+)";

        Map<String, List<String>> teamsStats = new HashMap<>();

        Pattern pattern = Pattern.compile(regex);
        String line = reader.readLine();
        while (!"Season End".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            matcher.find();
            String homeTeam = matcher.group("home");
            String awayTeam = matcher.group("away");
            String homeScore = matcher.group("homeScore");
            String awayScore = matcher.group("awayScore");

            if (!teamsStats.containsKey(homeTeam)) {
                teamsStats.put(homeTeam, new ArrayList<>());
            }

            if (!teamsStats.containsKey(awayTeam)) {
                teamsStats.put(awayTeam, new ArrayList<>());
            }
            String homeGame = " - " + awayTeam + " -> " + homeScore + ":" + awayScore;
            String awayGame = " - " + homeTeam + " -> " + awayScore + ":" + homeScore;
            teamsStats.get(homeTeam).add(homeGame);
            teamsStats.get(awayTeam).add(awayGame);

            line = reader.readLine();
        }

        String[] teams = reader.readLine().split(", ");
        printResult(teamsStats, teams);
    }

    private static void printResult(Map<String, List<String>> teamsStats, String[] teams) {
        for (String team : teams) {
            teamsStats.get(team).stream()
                    .sorted(Comparator.comparing(x -> x.split(" -> ")[0]))
                    .forEach(x -> System.out.println(String.format("%s%s", team, x)));
        }
    }
}
