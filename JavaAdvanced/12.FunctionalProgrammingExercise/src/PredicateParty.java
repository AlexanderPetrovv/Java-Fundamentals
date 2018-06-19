import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());;

        String commandLine = reader.readLine();
        while (!"Party!".equals(commandLine)) {
            String[] tokens = commandLine.split(" ");
            String command = tokens[0];
            String condition = tokens[1];
            String parameter = tokens[2];

            if (guests.isEmpty()) {
                System.out.println("Nobody is going to the party!");
                return;
            }

            Predicate<String> checkCond = getPredicate(condition, parameter);

            if ("Remove".equals(command)) {
                guests.removeIf(checkCond);
            } else {
                List<String> extraGuests = new ArrayList<>();
                for (String guest : guests) {
                    if (checkCond.test(guest)) {
                        extraGuests.add(guest);
                    }
                    extraGuests.add(guest);
                }
                guests = extraGuests;
            }

            commandLine = reader.readLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }
        System.out.println(String.format("%s are going to the party!", String.join(", ", guests)));
    }

    private static Predicate<String> getPredicate(String condition, String param) {
        switch (condition) {
            case "StartsWith":
                return x -> x.startsWith(param);
            case "EndsWith":
                return x -> x.endsWith(param);
            default:
                return x -> x.length() == Integer.parseInt(param);
        }
    }
}
