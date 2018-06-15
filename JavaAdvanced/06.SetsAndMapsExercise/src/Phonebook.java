import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new TreeMap<>();
        String line = scanner.nextLine();
        while(!"search".equals(line)) {
            String[] lineTokens = line.split("-");
            String name = lineTokens[0];
            String number = lineTokens[1];
            phonebook.put(name, number);
            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!"stop".equals(line)) {
            if (phonebook.containsKey(line)) {
                System.out.println(line + " -> " + phonebook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.%n", line);
            }
            line = scanner.nextLine();
        }
    }
}
