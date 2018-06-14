import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operationsCnt = Integer.parseInt(scanner.nextLine());
        StringBuilder builder = new StringBuilder();
        ArrayDeque<String> stackAppended = new ArrayDeque<>();
        for (int i = 0; i < operationsCnt; i++) {
            String[] lineTokens = scanner.nextLine().split(" ");

            String op = lineTokens[0];
            String arg = null;
            if (lineTokens.length > 1) {
                arg = lineTokens[1];
            }

            switch (op) {
                case "1":
                    stackAppended.push(builder.toString());
                    builder.append(arg);
                    break;
                case "2":
                    stackAppended.push(builder.toString());
                    int deleteCnt = Integer.parseInt(arg);
                    builder.delete(builder.length() - deleteCnt, builder.length());
                    break;
                case "3":
                    int position = Integer.parseInt(arg);
                    System.out.println(builder.charAt(position - 1));
                    break;
                case "4":
                    builder = new StringBuilder(stackAppended.pop());
                    break;
            }
        }
    }
}
