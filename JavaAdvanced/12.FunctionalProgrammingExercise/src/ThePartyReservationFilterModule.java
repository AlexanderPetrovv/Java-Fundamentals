import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> invitations = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        Map<String, Predicate<String>> filters = new HashMap<>();

        String line = reader.readLine();
        while (!"Print".equals(line)) {
            String[] tokens = line.split(";");
            String filterCmd = tokens[0];
            String filterType = tokens[1];
            String filterParam = tokens[2];

            String finalFilter = filterType + " " + filterParam;

            Predicate predicate = getPredicate(filterType, filterParam);

            if ("Add filter".equals(filterCmd)) {
                filters.putIfAbsent(finalFilter, predicate);
            } else {
                if (filters.containsKey(finalFilter)) {
                    filters.remove(finalFilter);
                }
            }
            line = reader.readLine();
        }

        invitations.stream()
                .filter(filters.values().stream()
                        .reduce(Predicate::and).orElse(x -> true))
                        .forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filterType, String filterParam) {
        if ("Starts with".equals(filterType)) {
            return x -> !x.startsWith(filterParam);
        } else if ("Ends with".equals(filterType)) {
            return x -> !x.endsWith(filterParam);
        } else if ("Length".equals(filterType)) {
            return x -> x.length() != Integer.parseInt(filterParam);
        } else {
            return x -> !x.contains(filterParam);
        }
    }
}
