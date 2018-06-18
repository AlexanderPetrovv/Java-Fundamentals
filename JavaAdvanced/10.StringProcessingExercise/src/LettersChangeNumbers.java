import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        double sum = 0;
        for (String token : tokens) {
            char firstLetter = token.charAt(0);
            char lastLetter = token.charAt(token.length() - 1);
            double number = Double.parseDouble(token.substring(1, token.length() - 1));
            int firstLetterPosition = getAlphabetPosition(firstLetter);
            int lastLetterPosition = getAlphabetPosition(lastLetter);

            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetterPosition;
            } else {
                number *= firstLetterPosition;
            }

            if (Character.isUpperCase(lastLetter)) {
                number -= lastLetterPosition;
            } else {
                number += lastLetterPosition;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }

    private static int getAlphabetPosition(char letter) {
        if (Character.isUpperCase(letter)) {
            return (int)letter - 64;
        } else {
            return (int)letter - 96;
        }
    }
}
