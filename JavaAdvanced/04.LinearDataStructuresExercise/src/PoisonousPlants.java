import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;


public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPlants = Integer.parseInt(reader.readLine());

        String[] plantsTokens = reader.readLine().split(" ");
        ArrayDeque<Integer> indices = new ArrayDeque<>();
        indices.push(0);

        int[] days = new int[numberOfPlants];
        for (int i = 1; i < numberOfPlants; i++) {
            int maxDays = 0;
            while(indices.size() > 0 &&
                    Integer.parseInt(plantsTokens[indices.peek()]) >= Integer.parseInt(plantsTokens[i])) {
                maxDays = Math.max(maxDays, days[indices.pop()]);
            }

            if(indices.size() > 0) {
                days[i] = maxDays + 1;
            }

            indices.push(i);
        }
        
        System.out.println(getMaxDays(days));
    }

    private static int getMaxDays(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
}
