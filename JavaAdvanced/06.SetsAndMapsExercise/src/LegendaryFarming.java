import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> collectedMaterials = new LinkedHashMap<>();
        collectedMaterials.put("fragments", 0);
        collectedMaterials.put("shards", 0);
        collectedMaterials.put("motes", 0);

        String line;
        String keyItems = "";
        boolean isCollected = false;

        while(!isCollected) {
            line = scanner.nextLine();
            String[] lineTokens = line.toLowerCase().split(" ");

            for (int i = 0; i < lineTokens.length; i += 2) {
                int quantity = Integer.parseInt(lineTokens[i]);
                String material = lineTokens[i + 1];

                if(!collectedMaterials.containsKey(material)) {
                    collectedMaterials.put(material, 0);
                }
                int oldValue = collectedMaterials.get(material);
                collectedMaterials.put(material, oldValue + quantity);

                if (collectedMaterials.get(material) >= 250 &&
                        (material.equals("shards") || material.equals("fragments") || material.equals("motes"))) {
                    collectedMaterials.put(material, collectedMaterials.get(material) - 250);
                    keyItems = material;
                    isCollected = true;
                    break;
                }
            }
        }

        String legendary = getLegendary(keyItems);
        System.out.println(legendary + " obtained!");
        Map<String, Integer> sortedKeyMaterials = collectedMaterials.entrySet().stream()
                .limit(3)
                .sorted((a, b) -> {
                    if (b.getValue() != a.getValue()) {
                        return Integer.compare(b.getValue(), a.getValue());
                    } else {
                        return a.getKey().compareTo(b.getKey());
                    }
                })
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);

        Map<String, Integer> sortedJunkMaterials = collectedMaterials.entrySet().stream()
                .skip(3)
                .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);

        for (Map.Entry<String,Integer> keyMaterial : sortedKeyMaterials.entrySet()) {
            System.out.printf("%s: %d%n", keyMaterial.getKey(), keyMaterial.getValue());
        }

        for (Map.Entry<String, Integer> junkMaterial : sortedJunkMaterials.entrySet()) {
            System.out.printf("%s: %d%n", junkMaterial.getKey(), junkMaterial.getValue());
        }
    }

    private static String getLegendary(String keyItems) {
        String legendary = "";
        switch (keyItems) {
            case "shards": legendary = "Shadowmourne"; break;
            case "motes": legendary = "Dragonwrath"; break;
            case "fragments": legendary = "Valanyr"; break;
        }
        return legendary;
    }
}
