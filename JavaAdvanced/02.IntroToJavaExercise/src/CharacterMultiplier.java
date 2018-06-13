import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String firstStr = tokens[0];
        String secondStr = tokens[1];

        int length = Math.max(firstStr.length(), secondStr.length());
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (i < firstStr.length() && i < secondStr.length()) {
                result += firstStr.charAt(i) * secondStr.charAt(i);
            } else if (i < firstStr.length()) {
                result += firstStr.charAt(i);
            } else if (i < secondStr.length()) {
                result += secondStr.charAt(i);
            }
        }
        System.out.println(result);
    }
}
