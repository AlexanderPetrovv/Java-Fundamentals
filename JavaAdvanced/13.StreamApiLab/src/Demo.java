import jdk.nashorn.internal.runtime.options.Option;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<String>() {{
            add("Pesho");
            add("Gosho");
            add("Tosho");
        }};

        // String alex = names.stream().filter(x -> x.equals("Alex")).findFirst().orElse(null);
        // System.out.println(alex == null ? "Missing" : alex);
        Optional<String> alex = names.stream().filter(x -> x.equals("Alex")).findFirst();

        // alex.ifPresent(System.out::println);
        if (alex.isPresent()) {
            System.out.println(alex.get());
        } else {
            System.out.println("Missing!");
        }
    }
}
