import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();
        String targetDomain = "@gmail.com";

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            String email = tokens[2];

            students.put(name, email);
            line = reader.readLine();
        }

        students.entrySet().stream()
                .filter(kvp -> kvp.getValue().endsWith(targetDomain))
                .forEach(kvp -> System.out.println(kvp.getKey()));
    }
}
