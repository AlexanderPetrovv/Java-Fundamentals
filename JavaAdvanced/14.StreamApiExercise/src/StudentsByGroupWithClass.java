import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByGroupWithClass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String targetGroup = "2";
        List<Student> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] lineTokens = line.split("\\s+");
            String firstName = lineTokens[0];
            String lastName = lineTokens[1];
            String group = lineTokens[2];

            Student student = new Student(firstName, lastName, group);
            students.add(student);
            line = reader.readLine();
        }

        students.stream()
                .filter(s -> s.getGroup().equals(targetGroup))
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .forEach(System.out::println);
    }
}

class Student {
    private String firstName;
    private String lastName;
    private String group;

    public Student(String firstName, String lastName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
