import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StateMachineStringProcessing {
    public static void main(String[] args) throws IOException {
        // Check for string = "Programming";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();

        // state machine implementation
        // multiple transitions from a state are possible
        // there is case for each state
        // the default case handles invalid input
        int state = 0;
        int i = 0;
        while (i <= input.length) {
            switch (state) {
                case 0:  // Initial state
                    if (input[i] == 'p' || input[i] == 'P') state = 1;
                    else state = -1;
                    break;
                case 1: // P or p
                    if (input[i] == 'r') state = 2;
                    else state = -1;
                    break;
                case 2: // r
                    if (input[i] == 'o') state = 3;
                    else if (input[i] == 'a') state = 5;
                    else state = -1;
                    break;
                case 3: // o
                    if (input[i] == 'g') state = 4;
                    else state = 10;
                    break;
                case 4: // g
                    if (i == 11) {  // End state
                        System.out.println("Word is valid"); return;
                    } else if (input[i] == 'r') {
                        state = 2;
                    } else {
                        state = -1;
                    }
                    break;
                case 5: // a
                    if (input[i] == 'm') state = 6;
                    else state = -1;
                    break;
                case 6: // m
                    if (input[i] == 'm') break;
                    else if (input[i] == 'i') state = 7;
                    else state = -1;
                    break;
                case 7: // i
                    if (input[i] == 'n') state = 8;
                    else state = -1;
                    break;
                case 8: // n
                    if (input[i] == 'g') state = 4;
                    else state = -1;
                    break;
                default:
                    System.out.println("The word is not valid");
                    break;
            }
            i++;
        }
    }
}
