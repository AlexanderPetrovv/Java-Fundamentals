import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userRegex = "(^|\\s)[a-zA-Z0-9]+[-_\\.]*[a-zA-Z0-9]*(?=@)";
        String hostRegex = "(?<=@)([a-zA-Z]+-*[a-zA-Z]*)(\\.[a-zA-Z]+-*[a-zA-Z]*)+(?=($|\\.|,|\\s+))";

        String text = reader.readLine();
        Pattern emailPattern = Pattern.compile(userRegex + "@" + hostRegex);
        Matcher matcher = emailPattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(0).trim());
        }
    }
}
