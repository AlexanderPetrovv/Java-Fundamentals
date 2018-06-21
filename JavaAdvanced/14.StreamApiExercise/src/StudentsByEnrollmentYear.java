import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // extract marks of students that enrolled in 2014 and 2015 year
        // 2014 students have 14 for 5th and 6th digits og faculty number
        // 2015 students have 15 for 5th and 6th digits of faculty number
        Map<String, List<String>> faculties = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String facultyNum = tokens[0];
            List<String> marks = new ArrayList<>();
            marks.addAll(Arrays.asList(tokens).subList(1, tokens.length));

            if (!faculties.containsKey(facultyNum)) {
                faculties.put(facultyNum, marks);
            }
            line = reader.readLine();
        }

        faculties.entrySet().stream()
                .filter(kvp -> kvp.getKey().endsWith("14") || kvp.getKey().endsWith("15"))
                .forEach(kvp -> System.out.println(String.format("%s", String.join(" ", kvp.getValue()))));
    }
}
