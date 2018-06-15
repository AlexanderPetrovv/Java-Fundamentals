import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();

        String[] firstPlayerTokens = scanner.nextLine().split(" ");
        String[] secondPlayerTokens = scanner.nextLine().split(" ");

        for (int i = 0; i < firstPlayerTokens.length; i++) {
            firstPlayerCards.add(Integer.parseInt(firstPlayerTokens[i]));
            secondPlayerCards.add(Integer.parseInt(secondPlayerTokens[i]));
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                System.out.println(firstPlayerCards.isEmpty() ? "Second player win!" : "First player win!");
                return;
            }

            int firstCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstCard);
            int secondCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
