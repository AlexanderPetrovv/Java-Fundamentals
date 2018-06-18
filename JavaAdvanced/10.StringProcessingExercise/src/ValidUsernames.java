import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String regex = "(?<=^|\\s|\\(|\\)|\\/|\\\\)[a-zA-Z]\\w{2,24}(?=$|\\s|\\(|\\)|\\/|\\\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int maxLen = Integer.MIN_VALUE;
        String longestSeq = "";
        String prev = "";

        while (matcher.find()) {
            String match = matcher.group();
            int currentLen = match.length() + prev.length();

            if (currentLen > maxLen) {
                longestSeq = prev + System.lineSeparator() + match;
                maxLen = currentLen;
            }
            prev = match;
        }
        System.out.println(longestSeq);
    }
}
