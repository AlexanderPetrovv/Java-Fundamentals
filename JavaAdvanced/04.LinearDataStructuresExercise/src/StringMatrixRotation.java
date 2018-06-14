import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotationTokens = scanner.nextLine().split("(\\D+)");
        int rotationDegrees = Integer.parseInt(rotationTokens[1]) % 360;
        ArrayList<String> words = new ArrayList<>();

        String line;
        while(!"END".equals(line = scanner.nextLine())) {
            words.add(line);
        }

        int rows = words.size();
        String longestWord = Collections.max(words, Comparator.comparing(String::length));
        int cols = longestWord.length();
        String[] matrix = fillStandardMatrix(words, rows, cols);

        switch (rotationDegrees) {
            case 0: printAt0Degrees(matrix); break;
            case 90: printAt90Degrees(matrix, cols, rows); break;
            case 180: rorate180Degrees(matrix, rows, cols); break;
            case 270: rorate270Degrees(matrix, cols, rows); break;
        }
    }

    private static void rorate270Degrees(String[] matrix, int height, int width) {
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[j].charAt(i));
            }
            System.out.println();
        }
    }

    private static void rorate180Degrees(String[] matrix, int height, int width) {
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                System.out.print(matrix[i].charAt(j));
            }
            System.out.println();
        }
    }

    private static void printAt90Degrees(String[] matrix, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = width - 1; j >= 0; j--) {
                System.out.print(matrix[j].charAt(i));
            }
            System.out.println();
        }
    }

    private static void printAt0Degrees(String[] matrix) {
        for (String aMatrix : matrix) {
            System.out.println(aMatrix);
        }
    }

    private static String[] fillStandardMatrix(ArrayList<String> words, int height, int width) {
        String[] matrix = new String[height];
        for (int i = 0; i < matrix.length; i++) {
            String format = "%-" + width + "s";
            String currentWord = String.format(format, words.get(i));
            matrix[i] = currentWord;
        }
        return matrix;
    }
}
