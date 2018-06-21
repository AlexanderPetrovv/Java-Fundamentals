import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] lineTokens = line.split("\\s+");
            String firstName = lineTokens[0];
            String lastName = lineTokens[1];

            Pair<String, String> fullName = new Pair<>(firstName, lastName);
            students.add(fullName);
            line = reader.readLine();
        }

        students.stream()
                .sorted((s1, s2) -> {
                    int comparatorLastName = s1.getValue().compareTo(s2.getValue());
                    if (comparatorLastName != 0) {
                        return comparatorLastName;
                    }

                    int comparatorFirstName = s2.getKey().compareTo(s1.getKey());
                    return comparatorFirstName;
                })
                .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));

        // students.stream()
        //        .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName, Comparator.reverseOrder()))
        //        .forEach(System.out::println);
    }
}
