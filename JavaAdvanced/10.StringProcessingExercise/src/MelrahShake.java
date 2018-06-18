import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());

        while (!"".equals(pattern.toString())) {
            int firstPatternIndex = text.indexOf(pattern.toString());
            int lastPatternIndex = text.lastIndexOf(pattern.toString());
            int indexDiff = lastPatternIndex - firstPatternIndex;

            if (firstPatternIndex != -1 && indexDiff >= pattern.length()) {
                text.delete(lastPatternIndex, lastPatternIndex + pattern.length());
                text.delete(firstPatternIndex, firstPatternIndex + pattern.length());
                pattern.deleteCharAt(pattern.length()/2);
                System.out.println("Shaked it.");
            } else {
                System.out.println("No shake.");
                break;
            }
        }

        if ("".equals(pattern.toString())) {
            System.out.println("No shake.");
        }
        System.out.println(text.toString());
    }
}
