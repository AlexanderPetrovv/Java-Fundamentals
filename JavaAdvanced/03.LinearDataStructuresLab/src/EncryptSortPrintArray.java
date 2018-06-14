import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();
        }

        int[] encryptedNames = new int[n];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int currentNameSum = 0;
            for (int j = 0; j < name.length(); j++) {
                char currentLetter = name.charAt(j);
                if (isVowel(currentLetter)) {
                    currentNameSum += currentLetter * name.length();
                } else {
                    currentNameSum += currentLetter / name.length();
                }
            }
            encryptedNames[i] = currentNameSum;
        }

        Arrays.sort(encryptedNames);
        printArray(encryptedNames);
    }

    private static boolean isVowel(char letter) {
        char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
        for (char vowel : vowels) {
            if (vowel == Character.toLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private static void printArray(int[] values) {
        for (int value : values) {
            System.out.println(value);
        }
    }
}
