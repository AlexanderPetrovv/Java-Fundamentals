import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int players = Integer.parseInt(scanner.nextLine());

        String winner = "";
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < players; i++) {
            String name = scanner.nextLine();
            int nameScore = calculateNameScore(name);
            int initialScore = Integer.parseInt(scanner.nextLine());
            int totalScore = nameScore + initialScore;
            if (totalScore > maxScore) {
                maxScore = totalScore;
                winner = name;
            }
        }

        System.out.printf("The winner is %s - %d points", winner, maxScore);
    }

    private static int calculateNameScore(String name) {
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) % 2 == 0) {
                score += name.charAt(i);
            } else {
                score -= name.charAt(i);
            }
        }
        return score;
    }
}
