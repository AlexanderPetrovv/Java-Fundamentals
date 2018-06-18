import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keysString = reader.readLine();
        String text = reader.readLine();

        String keysRegex = "^([A-Za-z_]+)(?=\\d).*(?<=\\d)([A-Za-z_]+)$";
        Pattern patternKeys = Pattern.compile(keysRegex);
        Matcher matcherKeys = patternKeys.matcher(keysString);
        String startKey;
        String endKey;
        if (matcherKeys.find()) {
            startKey = matcherKeys.group(1);
            endKey = matcherKeys.group(2);
        } else {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String numberRegex = "(\\d*(?:\\.\\d+)?)";
        Pattern textPattern = Pattern.compile(startKey + numberRegex + endKey);
        Matcher textMatcher = textPattern.matcher(text);

        double sum = 0;
        while (textMatcher.find() && !textMatcher.group(1).isEmpty()) {
            double num = Double.parseDouble(textMatcher.group(1));
            sum += num;
        }

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            if (sum == (int) sum) {
                System.out.printf("<p>The total value is: <em>%d</em></p>", (int) sum);
            } else {
                System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
            }
        }
    }
}
