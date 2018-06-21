import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<Pair<String, String>>> students = new HashMap<>();
        int targetGroup = 2;

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] lineTokens = line.split("\\s+");
            String firstName = lineTokens[0];
            String lastName = lineTokens[1];
            int group = Integer.parseInt(lineTokens[2]);

            if (!students.containsKey(group)) {
                students.put(group, new ArrayList<>());
            }
            Pair<String, String> fullName = new Pair<>(firstName, lastName);
            students.get(group).add(fullName);
            line = reader.readLine();
        }

        students.entrySet().stream()
                .filter(kv -> kv.getKey() == targetGroup)
                .forEach(kv -> kv.getValue().stream()
                        .sorted((name1, name2) -> name1.getKey().compareTo(name2.getKey()))
                        .forEach(name -> System.out.println(String.format("%s %s", name.getKey(), name.getValue()))));
    }
}
