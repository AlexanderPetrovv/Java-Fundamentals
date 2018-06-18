import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^\\+359([ -])2\\1\\d{3}\\1\\d{4}$";

        String phone;
        while (!"end".equals(phone = reader.readLine())) {
            if (Pattern.matches(regex, phone)) {
                System.out.println(phone);
            }
        }
    }
}
