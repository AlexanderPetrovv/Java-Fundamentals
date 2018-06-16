import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String wordsPath = "./resources/words.txt";
        String textPath = "./resources/text.txt";
        String resultPath = "./resources/result.txt";

        Map<String, Integer> targetWords = new HashMap<>();
        Map<String, String> originalWords = new HashMap<>();

        try (BufferedReader wordsReader = new BufferedReader(new FileReader(wordsPath));
             BufferedReader textReader = new BufferedReader(new FileReader(textPath));
             PrintWriter writer = new PrintWriter(new FileWriter(resultPath))) {
            String wordsLine = wordsReader.readLine();
            while (wordsLine != null) {
                String[] words = wordsLine.split(" ");
                for (String word : words) {
                    String wordToLower = word.toLowerCase();
                    if (!targetWords.containsKey(word)) {
                        targetWords.put(wordToLower, 0);
                        originalWords.put(wordToLower, word);
                    }
                }
                wordsLine = wordsReader.readLine();
            }

            String textLine = textReader.readLine();
            while (textLine != null) {
                String[] textTokens = textLine.split("[ ,]");
                for (String token : textTokens) {
                    String tokenToLower = token.toLowerCase();
                    if (targetWords.containsKey(tokenToLower)) {
                        targetWords.put(tokenToLower, targetWords.get(tokenToLower) + 1);
                    }
                }
                textLine = textReader.readLine();
            }

            Map<String, Integer> sortedTargetWords = targetWords.entrySet().stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, Integer> wordEntry : sortedTargetWords.entrySet()) {
                writer.printf("%s - %d%n", originalWords.get(wordEntry.getKey()), sortedTargetWords.get(wordEntry.getKey()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
