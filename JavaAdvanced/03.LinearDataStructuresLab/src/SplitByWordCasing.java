import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine()
                .split("[,;:.!/()'\\\\\"\\[\\] ]");

        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();

        for (String word : words) {
            if (word.trim().length() == 0) {
                continue;
            }
            boolean isMixed = false;
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    mixedCaseWords.add(word);
                    isMixed = true;
                    break;
                }
            }

            if (!isMixed) {
                if (word.toLowerCase().equals(word)) {
                    lowerCaseWords.add(word);
                } else if (word.toUpperCase().equals(word)) {
                    upperCaseWords.add(word);
                } else {
                    mixedCaseWords.add(word);
                }
            }
        }

        System.out.println("Lower-case: " + String.join(", ", lowerCaseWords));
        System.out.println("Mixed-case: " + String.join(", ", mixedCaseWords));
        System.out.println("Upper-case: " + String.join(", ", upperCaseWords));
    }
}
