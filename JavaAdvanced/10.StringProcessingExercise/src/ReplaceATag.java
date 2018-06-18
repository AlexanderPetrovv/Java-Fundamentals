import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            sb.append(line).append(System.lineSeparator());
        }

        String result = sb.toString();
        String regex = "(<a)\\s+href[^>]+(>)(\\s*.*?)(</a>)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            String fullMatch = matcher.group(0);
            String openATag = matcher.group(1);
            String closeOpenATag = matcher.group(2);
            String closeATag = matcher.group(4);
            String replacement = fullMatch.replaceFirst(openATag, "[URL");
            replacement = replacement.replaceFirst(closeOpenATag, "]");
            replacement = replacement.replaceFirst(closeATag, "[/URL]");
            result = result.replace(fullMatch, replacement);
        }

        System.out.println(result);
    }
}
