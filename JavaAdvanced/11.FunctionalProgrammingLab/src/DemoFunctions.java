import java.util.Random;
import java.util.function.*;

public class DemoFunctions {
    public static void main(String[] args) {

        // returns value, call method = apply()
        Function<Integer, Double> func = num -> num / 2.0;
        double result = func.apply(9);

        // void, call method = accept(), example forEach()
        Consumer<Integer> print = num -> System.out.println(num);
        print.accept(8);

        // accepts nothing, returns(supplies) something, call method = get()
        Supplier<Integer> genRandomInt = () -> new Random().nextInt(51);
        int randomNum = genRandomInt.get();

        // evaluates a condition, returns true or false, call method = test(), example removeIf()
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(6));

		// comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order
		Comparator<Integer> compare = (first, second) -> { return first - second; }
        // operation on single operand that produces a result of same type, call method = apply()
        UnaryOperator<Double> vat = price -> price * 1.2;
        double tomatoVat = vat.apply(3.0);

        // tow or more parameters, BiConsumer<T, U>, BiPredicate<T, U>
        BiFunction<Integer, Integer, String> sumNums = (x, y) -> "Sum is " + x + y;
        String sum = sumNums.apply(5, 6);

        // we can pass Function<T, R> to methods
        int a = 5;
        int b = operation(a, number -> number * 5);
        int c = operation(a, number -> number - 3);
        int d = operation(b, number -> number % 2);

    }

    public static int operation(int number, Function<Integer, Integer> function) {
        return function.apply(number);
    }
}
