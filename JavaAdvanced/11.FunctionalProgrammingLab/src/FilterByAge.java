import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] personTokens = reader.readLine().split(", ");
            people.putIfAbsent(personTokens[0], Integer.parseInt(personTokens[1]));
        }
        String condition = reader.readLine();
        int conditionAge = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> testAge = getTestCondition(condition, conditionAge);
        Consumer<Map.Entry<String, Integer>> printResult = getPrintFormat(format);

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (testAge.test(person.getValue())) {
                printResult.accept(person);
            }
        }
    }

    private static Predicate<Integer> getTestCondition(String condition, int conditionAge) {
        if ("younger".equals(condition)) {
            return x -> x < conditionAge;
        } else {
            return x -> x >= conditionAge;
        }
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintFormat(String format) {
        if ("name".equals(format)) {
            return person -> System.out.printf("%s%n", person.getKey());
        } else if ("age".equals(format)) {
            return person -> System.out.printf("%d%n", person.getValue());
        } else {
            return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }
    }
}
