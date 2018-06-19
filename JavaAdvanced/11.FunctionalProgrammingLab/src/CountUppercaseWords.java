import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        Predicate<String> isUppercase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> uppercaseWords = new ArrayList<>();
        for (String s : input) {
            if (isUppercase.test(s)) {
                uppercaseWords.add(s);
            }
        }
        System.out.println(uppercaseWords.size());
        System.out.println(String.join(System.lineSeparator(), uppercaseWords));
    }
}
