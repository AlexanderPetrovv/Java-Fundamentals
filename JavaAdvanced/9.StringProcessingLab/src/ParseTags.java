import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String startTag = "<upcase>";
        String endTag = "</upcase>";

        while(text.contains(startTag)) {
            int startIndex = text.indexOf(startTag);
            int endIndex = text.indexOf(endTag);

            String remainder = text.substring(startIndex + 8, endIndex);
            String toUpper = remainder.toUpperCase();
            text = text.replaceFirst(remainder, toUpper);
            text = text.replaceFirst(startTag, "");
            text = text.replaceFirst(endTag, "");
        }
        System.out.println(text);
    }
}
