import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String pattern = "[AEOIUYaeoiuy]";
        Pattern compiled = Pattern.compile(pattern);
        Matcher matcher = compiled.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Vowels: " + count);
    }
}
