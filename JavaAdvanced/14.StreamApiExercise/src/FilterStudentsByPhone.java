import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> studentsPhones = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            String phone = tokens[2];

            studentsPhones.put(name, phone);
            line = reader.readLine();
        }

        studentsPhones.entrySet().stream()
                .filter(kvp -> kvp.getValue().startsWith("02") || kvp.getValue().startsWith("+3592"))
                .forEach(kvp -> System.out.println(kvp.getKey()));
    }
}
