import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter {
    private static Map<String, Map<String, Long>> populationReport = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!"report".equals(line)) {
            fillReport(line);
            line = scanner.nextLine();
        }
        printReport();
    }

    private static void printReport() {
        Map<String, Map<String, Long>> sortedCountries = sortCountries();

        for (Map.Entry<String, Map<String, Long>> country : sortedCountries.entrySet()) {
            StringBuilder sb = new StringBuilder();
            long totalPopulation = 0;
            Map<String, Long> cities = country.getValue();
            Map<String, Long> sortedCities = cities.entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {
                sb.append("=>").append(city.getKey()).append(": ")
                        .append(city.getValue()).append(System.getProperty("line.separator"));
                totalPopulation += city.getValue();
            }
            System.out.printf("%s (total population: %d)%n", country.getKey(), totalPopulation);
            System.out.print(sb.toString());
        }
    }

    private static LinkedHashMap<String, Map<String, Long>> sortCountries() {
        return populationReport.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    long population1 = c1.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    long population2= c2.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    int comparator = Long.compare(population2, population1);
                    // long comparator = population2 - population1;
                    return comparator;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    private static void fillReport(String line) {
        String[] lineTokens = line.split("\\|");
        String country = lineTokens[1];
        String city = lineTokens[0];
        long population = Long.parseLong(lineTokens[2]);

        if (!populationReport.containsKey(country)) {
            populationReport.put(country, new LinkedHashMap<>());
        }

        populationReport.get(country).put(city, population);
    }
}
