import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "./resources/input.txt";
        String outputPath = "./resources/outputCountCharTypes.txt";

        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        List<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputPath)))) {
            String line = in.readLine();
            int vowelsCnt = 0;
            int consonantsCnt = 0;
            int punctMarksCnt = 0;
            while (line != null) {
                char[] chars = line.toCharArray();
                for (char ch : chars) {
                    if (!Character.isWhitespace(ch)) {
                        if (vowels.contains(ch)) {
                            vowelsCnt++;
                        } else if (punctuation.contains(ch)) {
                            punctMarksCnt++;
                        } else {
                            consonantsCnt++;
                        }
                    }
                }
                line = in.readLine();
            }
            out.println("Vowels: " + vowelsCnt);
            out.println("Consonants: " + consonantsCnt);
            out.println("Punctuation: " + punctMarksCnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
