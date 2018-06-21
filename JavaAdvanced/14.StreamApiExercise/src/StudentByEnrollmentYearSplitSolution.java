import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentByEnrollmentYearSplitSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+", 2);
            String facultyNum = tokens[0];
            String grades = tokens[1];
            if (facultyNum.endsWith("14") || facultyNum.endsWith("15")) {
                System.out.println(grades);
            }
            line = reader.readLine();
        }
    }
}
