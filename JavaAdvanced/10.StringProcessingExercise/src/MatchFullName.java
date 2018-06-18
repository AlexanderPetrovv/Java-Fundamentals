import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        String name;
        while (!"end".equals(name = reader.readLine())) {
            if (Pattern.matches(regex, name)) {
                System.out.println(name);
            }
        }
    }
}
