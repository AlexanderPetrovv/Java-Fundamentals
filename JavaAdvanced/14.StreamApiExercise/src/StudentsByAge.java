import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> students = new LinkedHashMap<>();
        int lowerAgeLimit = 18;
        int upperAgeLimit = 24;

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] lineTokens = line.split("\\s+");
            String firstName = lineTokens[0];
            String lastName = lineTokens[1];
            int age = Integer.parseInt(lineTokens[2]);

            String fullName = firstName + " " + lastName;
            students.put(fullName, age);

            line = reader.readLine();
        }

        students.entrySet().stream()
                .filter(kv -> kv.getValue() >= lowerAgeLimit && kv.getValue() <= upperAgeLimit)
                .forEach(kv -> System.out.println(String.format("%s %d", kv.getKey(), kv.getValue())));
    }
}
