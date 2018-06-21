import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> studentsMarks = new LinkedHashMap<>();
        int targetWeakMark = 3;

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            List<Integer> marks = new ArrayList<>();
            for (int i = 2; i < tokens.length; i++) {
                marks.add(Integer.parseInt(tokens[i]));
            }

            if (!studentsMarks.containsKey(name)) {
                studentsMarks.put(name, marks);
            }
            line = reader.readLine();
        }

        studentsMarks.entrySet().stream()
                .filter(kvp -> kvp.getValue().stream().filter(grade -> grade <= targetWeakMark).count() >= 2)
                .forEach(kvp -> System.out.println(kvp.getKey()));
    }
}
