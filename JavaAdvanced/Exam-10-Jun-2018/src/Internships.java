import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemsCnt = Integer.parseInt(reader.readLine());
        int candidatesCnt = Integer.parseInt(reader.readLine());

        Deque<String> problemsStack = new ArrayDeque<>();
        Deque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < problemsCnt; i++) {
            String problem = reader.readLine();
            problemsStack.push(problem);
        }

        for (int i = 0; i < candidatesCnt; i++) {
            String candidate = reader.readLine();
            if (isValidCandidateName(candidate)) {
                candidatesQueue.offer(candidate);
            }
        }

        while (!problemsStack.isEmpty()) {
            String currentProblem = problemsStack.pop();
            String currentCandidate = candidatesQueue.poll();

            int problemValue = getStringValue(currentProblem);
            int candidateValue = getStringValue(currentCandidate);
            if (problemValue < candidateValue) {
                System.out.println(currentCandidate + " solved " + currentProblem + ".");
                candidatesQueue.offer(currentCandidate);
            } else {
                System.out.println(currentCandidate + " failed " + currentProblem + ".");
                problemsStack.addLast(currentProblem);
            }

            if (candidatesQueue.size() == 1) {
                System.out.println(candidatesQueue.poll() + " gets the job!");
                return;
            }
        }

        System.out.println(String.join(", ", candidatesQueue));
    }

    private static int getStringValue(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            value += str.charAt(i);
        }
        return value;
    }

    private static boolean isValidCandidateName(String candidate) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]*\\s?[A-Z][a-z]*$");
        Matcher matcher = pattern.matcher(candidate);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
