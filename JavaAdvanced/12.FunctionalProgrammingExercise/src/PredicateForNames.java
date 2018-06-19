import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int targetLen = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Predicate<String> checkNameLen = x -> x.length() <= targetLen;
        for (String name : names) {
            if (checkNameLen.test(name)) {
                System.out.println(name);
            }
        }
    }
}
