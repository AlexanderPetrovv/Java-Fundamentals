import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long snakeLen = 1L;
        int screenSize = Integer.parseInt(reader.readLine());

        if (screenSize == 0 || screenSize == 1) {
            return;
        }

        String[] directions = reader.readLine().split(", ");
        String[][] screenMatrix = new String[screenSize][screenSize];


        int snakeRow = -1;
        int snakeCol = -1;

        for (int i = 0; i < screenSize; i++) {
            String[] rowElements = reader.readLine().split(" ");
            for (int j = 0; j < rowElements.length; j++) {
                screenMatrix[i][j] = rowElements[j];
                if ("s".equals(rowElements[j])) {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }

        boolean gotToEnemy = false;
        for (int i = 0; i < directions.length; i++) {

            String currentDirection = directions[i];
            if ("up".equals(currentDirection)) {
                snakeRow -= 1;
                if (snakeRow < 0) {
                    snakeRow = screenMatrix.length - 1;
                }
            } else if ("down".equals(currentDirection)) {
                snakeRow += 1;
                if (snakeRow > screenMatrix.length - 1) {
                    snakeRow = 0;
                }
            } else if ("right".equals(currentDirection)) {
                snakeCol += 1;
                if (snakeCol > screenMatrix.length - 1) {
                    snakeCol = 0;
                }
            } else if ("left".equals(currentDirection)) {
                snakeCol -= 1;
                if (snakeCol < 0) {
                    snakeCol = screenMatrix.length - 1;
                }
            }

            // check for enemy on new coordinates
            if ("e".equals(screenMatrix[snakeRow][snakeCol])) {
                //System.out.println("You lose! Killed by an enemy!");
                gotToEnemy = true;
            }

            // check for food on new coordinates
            if ("f".equals(screenMatrix[snakeRow][snakeCol])) {
                snakeLen++;
                screenMatrix[snakeRow][snakeCol] = "*";
            }
        }

        long foodLeftCnt = checkMatrixForFood(screenMatrix);
        if (foodLeftCnt == 0) {
            System.out.println(String.format("You win! Final snake length is %d", snakeLen));
        } else if (gotToEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.println(String.format("You lose! There is still %d food to be eaten.", foodLeftCnt));
        }
    }

    private static long checkMatrixForFood(String[][] screenMatrix) {
        long cnt = 0;
        for (int i = 0; i < screenMatrix.length; i++) {
            for (int j = 0; j < screenMatrix.length; j++) {
                if ("f".equals(screenMatrix[i][j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
