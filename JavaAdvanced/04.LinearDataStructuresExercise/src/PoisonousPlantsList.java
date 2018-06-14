import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class PoisonousPlantsList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Hits time limit

        int n = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        List<Integer> nums = new LinkedList<>();
        List<Integer> indices = new LinkedList<>();

        nums.add(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            nums.add(Integer.parseInt(tokens[i]));
            if (Integer.parseInt(tokens[i]) > Integer.parseInt(tokens[i - 1])) {
                indices.add(i);
            }
        }

        int days = 0;
        while (indices.size() > 0) {
            for (int i = indices.size() - 1; i >= 0; i--) {
                int index = indices.get(i);
                nums.remove(index);
            }

            indices = new LinkedList<>();
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) < nums.get(i + 1)) {
                    indices.add(i + 1);
                }
            }
            days++;
        }
        System.out.println(days);
    }
}
