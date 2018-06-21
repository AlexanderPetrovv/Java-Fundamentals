import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));
        int minPopulation = Integer.parseInt(reader.readLine());
        Map<String, List<Integer>> cities = new HashMap<>();

        fillDictionary(tokens, cities);

        cities.entrySet().stream()
                .filter(es -> es.getValue().stream().mapToInt(Integer::valueOf).sum() >= minPopulation)
                .sorted((es1, es2) -> Integer.compare(
                        es2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        es1.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(es -> {
                    System.out.print(es.getKey() + ": ");
                    es.getValue().stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(pop -> System.out.print(pop + " "));
                    System.out.println();
                });

    }

    private static void fillDictionary(List<String> tokens, Map<String, List<Integer>> cities) {
        for (String token : tokens) {
            String[] cityTokens = token.split(":");
            String city = cityTokens[0];
            int districtPopulation = Integer.parseInt(cityTokens[1]);

            if (!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
            }
            cities.get(city).add(districtPopulation);
        }
    }
}
