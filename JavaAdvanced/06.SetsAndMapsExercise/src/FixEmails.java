import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"stop".equals(line)) {
            String name = line;
            String email = scanner.nextLine();
            if (isValid(email)) {
                emails.put(name, email);
            }
            line = scanner.nextLine();
        }

        for (Map.Entry<String,String> kvp : emails.entrySet()) {
            System.out.println(kvp.getKey() + " -> " + kvp.getValue());
        }
    }

    private static boolean isValid(String email) {
        return !email.toLowerCase().endsWith(".us") &&
                !email.toLowerCase().endsWith(".uk") &&
                !email.toLowerCase().endsWith(".com");
    }
}
