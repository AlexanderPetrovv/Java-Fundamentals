import java.util.Scanner;

public class ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers[i] = number;
        }

        String line;
        while (true) {
            if ("party over".equals(line = scanner.nextLine())) {
                break;
            }
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            int position = Integer.parseInt(tokens[1]);

            for (int i = 0; i < numbers.length; i++) {
                switch (command) {
                    case "-1": numbers[i] = flipBitAtPosition(numbers[i], position);
                        break;
                    case "0": numbers[i] = unsetBitAtPosition(numbers[i], position);
                        break;
                    case "1": numbers[i] = setBitAtPosition(numbers[i], position);
                        break;
                }
            }
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static int flipBitAtPosition(int number, int position) {
        return number ^ (1 << position);
    }

    public static int unsetBitAtPosition(int number, int position) {
        return number & ~(1 << position);
    }

    public static int setBitAtPosition(int number, int position) {
        return number | (1 << position);
    }
}
