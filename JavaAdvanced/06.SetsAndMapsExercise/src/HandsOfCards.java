import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"JOKER".equals(line)) {
            String[] lineTokens = line.split(": ");
            String name = lineTokens[0];
            String[] cardsTokens = lineTokens[1].split(", ");
            Set<String> cards = new HashSet<>();
            Collections.addAll(cards, cardsTokens);

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            Set<String> cardsOld = players.get(name);
            cardsOld.addAll(cards);
            players.put(name, cardsOld);

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            int totalCardValue = 0;
            for (String card : player.getValue()) {
                totalCardValue += calcCardValue(card);
            }
            System.out.printf("%s: %d%n", player.getKey(), totalCardValue);
        }
    }

    private static int calcCardValue(String card) {
        Map<String, Integer> cardPowers = new HashMap<String, Integer>() {{
           put("J", 11);
           put("Q", 12);
           put("K", 13);
           put("A", 14);
        }};

        for (int i = 2; i <= 10; i++)
        {
            cardPowers.put(Integer.toString(i), i);
        }

        Map<String, Integer> cardTypes = new HashMap<String, Integer>() {{
            put("S", 4);
            put("H", 3);
            put("D", 2);
            put("C", 1);
        }};

        String power = card.substring(0, card.length() - 1);
        String type = card.substring(card.length() - 1);
        return cardPowers.get(power) * cardTypes.get(type);
    }
}
