import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MagicExchangeableWords {
    private static Map<Character, Character> magicWords = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");
        String firstWord = strings[0];
        String secondWord = strings[1];

        System.out.println(areExchangeable(firstWord, secondWord));
    }

    private static boolean areExchangeable(String firstWord, String secondWord) {
        int minLen = Math.min(firstWord.length(), secondWord.length());

        for (int i = 0; i < minLen; i++) {
            char firstWordChar = firstWord.charAt(i);
            char secondWordChar = secondWord.charAt(i);

            if (!magicWords.containsKey(firstWordChar)) {
                if (!magicWords.containsValue(secondWordChar)) {
                    magicWords.put(firstWordChar, secondWordChar);
                } else {
                    return false;
                }
            } else {
                if (magicWords.get(firstWordChar) != secondWordChar) {
                    return false;
                }
            }
        }

        String longerWord = firstWord.length() > secondWord.length() ? firstWord : secondWord;
        for (int i = minLen; i < longerWord.length(); i++) {
            char currentChar = longerWord.charAt(i);
            if (!magicWords.containsKey(currentChar) && !magicWords.containsValue(currentChar)) {
                return false;
            }
        }
        return true;
    }
}
