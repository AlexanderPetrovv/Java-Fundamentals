import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> names = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] lineTokens = line.split("\\s+");
            String firstName = lineTokens[0];
            String lastName = lineTokens[1];

            Pair<String, String> name = new Pair<>(firstName, lastName);
            names.add(name);

            line = reader.readLine();
        }

        names.stream()
                .filter(name -> name.getKey().compareTo(name.getValue()) < 0)
                .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
    }
}
