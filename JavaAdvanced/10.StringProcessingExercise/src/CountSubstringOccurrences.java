import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine().toLowerCase();
        String subStr = reader.readLine().toLowerCase();

        int counter = 0;
        int index = text.indexOf(subStr);
        while (index != -1) {
            counter++;
            index = text.indexOf(subStr, index + 1);
        }
        System.out.println(counter);
    }
}
