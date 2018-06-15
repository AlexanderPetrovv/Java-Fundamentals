import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int nLen = Integer.parseInt(tokens[0]);
        int mLen = Integer.parseInt(tokens[1]);
        int totalLen = nLen + mLen;

        Set<String> nSet = new LinkedHashSet<>();
        Set<String> mSet = new LinkedHashSet<>();

        for (int i = 0; i < totalLen; i++) {
            if (i < nLen) {
                nSet.add(scanner.nextLine());
            } else {
                mSet.add(scanner.nextLine());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String e : nSet) {
            if (mSet.contains(e)) {
                sb.append(e).append(" ");
            }
        }
        if (!"".equals(sb.toString())) {
            System.out.println(sb.toString().trim());
        }
    }
}
