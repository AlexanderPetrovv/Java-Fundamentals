import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<Person>> groupsStudents = new TreeMap<>();
        //  List<Person> people = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            if (!groupsStudents.containsKey(group)) {
                groupsStudents.put(group, new ArrayList<>());
            }
            Person person = new Person(name, group);
            groupsStudents.get(group).add(person);
            line = reader.readLine();
        }

        groupsStudents.entrySet().stream()
                .forEach(kvp -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(kvp.getKey()).append(" - ");
                    kvp.getValue()
                            .forEach(p -> {
                                sb.append(p.getName()).append(", ");
                            });
                    System.out.println(sb.toString().substring(0, sb.lastIndexOf(",")));
                });

        // Map<Integer, List<Person>> peopleByGroup = people.stream().collect(Collectors.groupingBy(Person::getGroup));

//        peopleByGroup.forEach((key, value) ->
//                System.out.println(
//                        String.format("%d - %s", key,
//                                String.join(", ",
//                                        value.stream().map(p -> p.getName()).collect(Collectors.toList())))));

//        peopleByGroup.forEach((key, value) ->
//                System.out.println(
//                        String.format("%d - %s", key,
//                                value.stream().map(p -> p.getName()).collect(Collectors.joining(", ")))));

    }
}

class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }
}