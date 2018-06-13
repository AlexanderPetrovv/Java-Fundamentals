import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        String[] cmdTokens = scanner.nextLine().split("\\s+");

        int targetCount = Integer.parseInt(cmdTokens[1]);
        String type = cmdTokens[2];

        List<String> resultNums = new ArrayList<>();
        int counter = 0;
        for (String num : numbers) {
            if (counter >= targetCount) {
                break;
            }

            if (checkType(num, type)) {
                resultNums.add(num);
                counter++;
            }
        }

        System.out.println(String.join(" ", resultNums));


    }

    private static boolean checkType(String number, String type) {
        if ("even".equals(type)) {
            return Integer.parseInt(number) % 2 == 0;
        } else {
            return Integer.parseInt(number) % 2 != 0;
        }
    }
}
