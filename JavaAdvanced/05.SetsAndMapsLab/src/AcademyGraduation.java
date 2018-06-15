import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = readGrades(scanner);

            if (!students.containsKey(name)) {
                students.put(name, grades);
            }
        }

        for (Map.Entry<String, double[]> student : students.entrySet()) {
            double avg = 0;
            for (double v : student.getValue()) {
                avg += v;
            }
            avg /= student.getValue().length;
            System.out.printf("%s is graduated with %s%n",
                    student.getKey(),
                    avg);
        }
    }

    private static double[] readGrades(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(" ");
        double[] grades = new double[tokens.length];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = Double.parseDouble(tokens[i]);
        }
        return grades;
    }
}
