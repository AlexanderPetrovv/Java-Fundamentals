import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new HashSet<>();
        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String direction = line.split(", ")[0];
            String carNumber = line.split(", ")[1];

            if ("IN".equals(direction)) {
                cars.add(carNumber);
            }

            if ("OUT".equals(direction)) {
                if(cars.contains(carNumber)) {
                    cars.remove(carNumber);
                }
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
