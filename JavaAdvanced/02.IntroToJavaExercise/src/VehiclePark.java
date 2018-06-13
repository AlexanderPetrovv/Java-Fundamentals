import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allVehiclesTokens = scanner.nextLine().split("\\s+");
        List<String> vehicles = new ArrayList<>();
        Collections.addAll(vehicles, allVehiclesTokens);

        int soldVehicles = 0;
        String line;
        while (!"End of customers!".equals(line = scanner.nextLine())) {
            String[] requestTokens = line.split("\\s+");
            String vehicleType = requestTokens[0];
            int numberOfSeats = Integer.parseInt(requestTokens[2]);
            String request = getCurrentRequest(vehicleType, numberOfSeats);

            if (vehicles.contains(request)) {
                int price = calcVehiclePrice(request);
                soldVehicles++;
                System.out.println("Yes, sold for " + price + "$");
                vehicles.remove(request);
            } else {
                System.out.println("No");
            }
        }

        System.out.println("Vehicles left: " + String.join(", ", vehicles));
        System.out.println("Vehicles sold: " + soldVehicles);
    }

    private static int calcVehiclePrice(String request) {
        return request.charAt(0) * Integer.parseInt(request.substring(1));
    }

    private static String getCurrentRequest(String vehicleType, int numberOfSeats) {
        String request = "";
        switch (vehicleType) {
            case "Car": request = "c" + numberOfSeats; break;
            case "Bus": request ="b" + numberOfSeats; break;
            case "Van": request = "v" + numberOfSeats; break;
        }
        return request;
    }
}
