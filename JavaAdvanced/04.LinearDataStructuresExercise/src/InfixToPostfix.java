import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Reverse Polish Notation
        // Shunting-yard algorithm

        String[] expressionTokens = scanner.nextLine().split(" ");
        String outputExpression = shuntingYardAlgo(expressionTokens);
        System.out.println(outputExpression);
    }

    private static String shuntingYardAlgo(String[] expressionTokens) {
        StringBuilder builder = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String token : expressionTokens) {
            // check for operator
            if (isOperator(token)) {
                // check for empty stack and priority of the operations then appends the top element (operator)
                while(!stack.isEmpty() && !stack.peek().equals("(") && hasHigherPrecedence(stack.peek(), token)) {
                    builder.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else if (token.equals("(")) {
                // simply push the opening parenthesis in stack
                stack.push(token);
            } else if (token.equals(")")) {
                // check top element and remove and append operators until opening parenthesis is reached
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    builder.append(stack.pop()).append(" ");
                }
                // removes the last opening parenthesis thus one pair of parentheses and the expression within is done
                stack.pop();
            } else {
                // When char is a number simply appends to result
                builder.append(token).append(" ");
            }
        }

        // appends all the elements (operators) in the stack until it's empty
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        // returns the postfix expression
        return builder.toString();
    }

    private static boolean hasHigherPrecedence(String first, String second) {
        // get the weight of different operators
        int firstWeight = getOperatorWeight(first);
        int secondWeight = getOperatorWeight(second);

        // when precedence is equal return true if operator is left associative and false for right associative
        // those on the left are done before those on the right
        if (firstWeight == secondWeight) {
            if (isRightAssociative(first)) {
                return false;
            } else {
                return true;
            }
        }
        return firstWeight > secondWeight;
    }

    private static boolean isRightAssociative(String operator) {
        return operator.equals("$");
    }


    private static int getOperatorWeight(String operator) {
        int weight = 0;
        switch (operator) {
            case "+":
            case "-":
                weight = 1;
                break;
            case "*":
            case "/":
                weight = 2;
                break;
            case "$":
                weight = 3;
                break;
        }
        return weight;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("$");
    }
}
