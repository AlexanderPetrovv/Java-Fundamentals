import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        Matcher matcher;

        List<String> list = new ArrayList<>();

        String username;
        while (!"END".equals(username = reader.readLine())) {
            matcher = pattern.matcher(username);
            if (matcher.find()) {
                list.add("valid");
            } else {
                list.add("invalid");
            }
        }

        if (list.contains("valid")) {
            System.out.println(String.join("\n", list));
        }
    }
}
