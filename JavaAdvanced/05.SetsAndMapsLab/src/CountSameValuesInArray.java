import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //double[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        String[] nums = scanner.nextLine().split(" ");

        Map<String, Integer> occurences = new HashMap<>();

        for (String num :nums) {
            if (!occurences.containsKey(num)) {
                occurences.put(num, 0);
            }
            occurences.put(num, occurences.get(num) + 1);
        }

        for (String key : occurences.keySet()) {
            System.out.println(key + " - " + occurences.get(key) + " times");
        }
    }
}
