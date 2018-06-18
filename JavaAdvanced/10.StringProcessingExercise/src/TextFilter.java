import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(", ");
        String text = reader.readLine();

        for (String word : words) {
            String replaceValue = String.join("", Collections.nCopies(word.length(), "*"));
            text = text.replace(word, replaceValue);
        }
        System.out.println(text);
    }
}
