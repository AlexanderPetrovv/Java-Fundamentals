import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "([,_])([a-zA-Z]+)(\\d{1})";
        Pattern pattern = Pattern.compile(regex);
        Map<String, String> decryptedWords = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"Ascend".equals(line)) {
            for (Map.Entry<String, String> decWord : decryptedWords.entrySet()) {
                line = line.replaceAll(decWord.getKey(), decWord.getValue());
            }

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String decoded = decode(matcher);
                decryptedWords.putIfAbsent(matcher.group(0), decoded);
                line = line.replaceAll(matcher.group(0), decoded);
            }
            System.out.println(line);
            line = reader.readLine();
        }
    }

    private static String decode(Matcher matcher) {
        String condition = matcher.group(1);
        String text = matcher.group(2);
        int digit = Integer.parseInt(matcher.group(3));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentLetter = '\0';
            if (condition.equals(",")) {
                currentLetter = (char)(text.charAt(i) + digit);
            } else {  // if condition is "_"
                currentLetter = (char)(text.charAt(i) - digit);
            }
            sb.append(currentLetter);
        }
        return sb.toString();
    }
}
