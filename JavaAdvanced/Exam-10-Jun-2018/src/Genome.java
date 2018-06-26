import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genome {
    private static final String TERMINATE_CONDITION = "Stop!";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> genomesData = new LinkedHashMap<>();

        Pattern pattern = Pattern
                .compile("^(?<name>([!@#$?]*[a-z]+[!@#$?]*)+)=(?<nameLen>\\d+)--(?<geneCnt>\\d+)<<(?<organism>[a-z]+)$");

        String line = reader.readLine();
        while (!TERMINATE_CONDITION.equals(line)) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String name = matcher.group("name");
                int nameLen = Integer.parseInt(matcher.group("nameLen"));
                int geneCnt = Integer.parseInt(matcher.group("geneCnt"));
                String organism = matcher.group("organism");

                if (isValidLen(name, nameLen)) {
                    if (!genomesData.containsKey(organism)) {
                        genomesData.put(organism, 0);
                    }
                    int oldValue = genomesData.get(organism);
                    genomesData.put(organism, oldValue + geneCnt);
                }
            }
            line = reader.readLine();
        }

        genomesData.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(x -> System.out.println(String.format("%s has genome size of %d", x.getKey(), x.getValue())));
    }

    private static boolean isValidLen(String name, int nameLen) {
        int cnt = 0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i))) {
                cnt++;
            }
        }
        return cnt == nameLen;
    }
}
