import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<small>>-{5}>)|(?<medium>>>-{5}>)|(?<large>>>>-{5}>>)");

        int smallArrows = 0;
        int mediumArrows = 0;
        int largeArrows = 0;

        for (int i = 0; i < 4; i++) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (matcher.group("small") != null) {
                    smallArrows++;
                } else if (matcher.group("medium") != null) {
                    mediumArrows++;
                } else {
                    largeArrows++;
                }
            }
        }

        String arrows = "" + smallArrows + mediumArrows + largeArrows;
        String binary = Integer.toBinaryString(Integer.valueOf(arrows));
        String reversed = binary + new StringBuilder(binary).reverse();
        int result = Integer.parseInt(reversed, 2);
        System.out.println(result);
    }
}
