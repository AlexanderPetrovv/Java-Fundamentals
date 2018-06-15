import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> occurences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!occurences.containsKey(input.charAt(i))) {
                occurences.put(input.charAt(i), 0);
            }
            occurences.put(input.charAt(i), occurences.get(input.charAt(i)) + 1);
        }

        for (Character character : occurences.keySet()) {
            System.out.println(character + ": " + occurences.get(character) + " time/s");
        }
    }
}
