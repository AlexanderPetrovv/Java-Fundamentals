import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> companiesData = new TreeMap<>();
        int companiesCnt = Integer.parseInt(reader.readLine());

        String line;
        for (int i = 0; i < companiesCnt; i++) {
            line = reader.readLine();
            String[] tokens = line.split(" - ");
            String company = tokens[0].substring(1);
            int amount = Integer.parseInt(tokens[1]);
            String product = tokens[2].substring(0, tokens[2].length() - 1);

            if (!companiesData.containsKey(company)) {
                companiesData.put(company, new LinkedHashMap<>());
            }

            if (!companiesData.get(company).containsKey(product)) {
                companiesData.get(company).put(product, 0);
            }
            int oldValue = companiesData.get(company).get(product);
            companiesData.get(company).put(product, oldValue + amount);
        }

        companiesData.entrySet().stream()
                .forEach(companyEntry -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(companyEntry.getKey()).append(": ");
                    companyEntry.getValue().entrySet().stream()
                            .forEach(productEntry -> {
                                sb.append(productEntry.getKey()).append("-").append(productEntry.getValue()).append(", ");
                            });
                    System.out.println(sb.toString().substring(0, sb.lastIndexOf(",")));
                });
    }
}
