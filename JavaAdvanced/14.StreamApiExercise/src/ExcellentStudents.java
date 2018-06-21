import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> studentsMarks = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            String name = firstName + " " + lastName;
            List<String> grades = new ArrayList<>();
            grades.addAll(Arrays.asList(tokens).subList(2, tokens.length));
            if (!studentsMarks.containsKey(name)) {
                studentsMarks.put(name, grades);
            }

            line = reader.readLine();
        }

        studentsMarks.entrySet().stream()
                .filter(kvp -> kvp.getValue().stream().anyMatch(grade -> grade.equals("6")))
                .forEach(kvp -> System.out.println(kvp.getKey()));
    }
}
