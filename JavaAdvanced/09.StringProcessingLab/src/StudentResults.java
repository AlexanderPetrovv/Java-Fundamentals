import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] inputTokens = input.split("[,\\s-]+");

        double average = calcAverage(inputTokens);
        printTableHeader();
        printTableBody(inputTokens, average);
    }

    private static void printTableBody(String[] inputTokens, double average) {
        String body = String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                inputTokens[0],
                Double.parseDouble(inputTokens[1]),
                Double.parseDouble(inputTokens[2]),
                Double.parseDouble(inputTokens[3]),
                average);
        System.out.println(body);
    }

    private static void printTableHeader() {
        String header = String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.println(header);
    }

    private static double calcAverage(String[] inputTokens) {
        double average = 0;
        for (int i = 1; i < inputTokens.length; i++) {
            average += Double.parseDouble(inputTokens[i]);
            if (i == inputTokens.length - 1) {
                average /= 3;
            }
        }
        return average;
    }
}
