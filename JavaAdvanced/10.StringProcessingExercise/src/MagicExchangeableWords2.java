import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MagicExchangeableWords2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");
        char[] firstWord = strings[0].toCharArray();
        char[] secondWord = strings[1].toCharArray();

        Set<Character> firstSet = new HashSet<>();
        for (char ch : firstWord) {
            firstSet.add(ch);
        }
        Set<Character> secondSet = new HashSet<>();
        for (char ch : secondWord) {
            secondSet.add(ch);
        }
        System.out.println(firstSet.size() == secondSet.size());
    }
}
