import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder firstNum = new StringBuilder(reader.readLine());
        StringBuilder secondNum = new StringBuilder(reader.readLine());
        String result = sumNumbers(firstNum, secondNum);
        System.out.println(trimLeadingZeroes(result));
    }

    private static String sumNumbers(StringBuilder firstNum, StringBuilder secondNum) {
        firstNum.reverse();
        secondNum.reverse();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int digitToAdd;
        int len = Math.max(firstNum.length(), secondNum.length());
        for (int i = 0; i < len; i++) {
            int firstNumDigit = getDigit(firstNum, i);
            int secondNumDigit = getDigit(secondNum, i);

            int digitSum = firstNumDigit + secondNumDigit + carry;
            carry = digitSum / 10;
            digitToAdd = digitSum % 10;
            result.append(digitToAdd);
            if (i == len - 1) {
                result.append(carry);
            }
        }
        return result.reverse().toString();
    }

    private static int getDigit(StringBuilder num, int index) {
        if (index < num.length()) {
            return Integer.parseInt(String.valueOf(num.charAt(index)));
        } else {
            return 0;
        }
    }
    
    private static String trimLeadingZeroes(String number) {
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0'){
                break;
            }
            counter++;
        }
        return number.substring(counter);
    }
}
