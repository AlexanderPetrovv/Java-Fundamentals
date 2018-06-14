import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;

public class Robotics {
    private static ArrayDeque<Robot> robotsQueue = new ArrayDeque<>();
    private static ArrayDeque<String> productsQueue = new ArrayDeque<>();
    private static int time = 0;
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputTokens = reader.readLine().split(";");
        String[] startingTimeTokens = reader.readLine().split(":");
        time = Integer.parseInt(startingTimeTokens[0]) * 3600 +
                Integer.parseInt(startingTimeTokens[1]) * 60 +
                Integer.parseInt(startingTimeTokens[2]);

        for (String rt : inputTokens) {
            String[] robotTokens = rt.split("-");
            Robot robot = new Robot();
            robot.name = robotTokens[0];
            robot.workTime = Integer.parseInt(robotTokens[1]);
            robot.finishingTime = time;
            robotsQueue.offer(robot);
        }

        String product;
        time++;
        while (!"End".equals(product = reader.readLine())) {
            boolean isProcessed = false;
            for (Robot robot : robotsQueue) {
                if (time >= robot.finishingTime) {
                    robot.finishingTime = robot.workTime + time;
                    String formattedTime = getTime();
                    builder.append(String.format("%s - %s [%s]%n", robot.name, product, formattedTime));
                    isProcessed = true;
                    time++;
                    break;
                }
            }
            if (!isProcessed) {
                productsQueue.offer(product);
                time++;
            }
        }

        while (!productsQueue.isEmpty()) {
            processProduct();
        }

        System.out.println(builder.toString());
    }

    private static void processProduct() {
        boolean isProcessed = false;
        for (Robot robot : robotsQueue) {
            if (!productsQueue.isEmpty()) {
                if (time >= robot.finishingTime) {
                    robot.finishingTime = robot.workTime + time;
                    String formattedTime = getTime();
                    builder.append(String.format("%s - %s [%s]%n", robot.name, productsQueue.poll(), formattedTime));
                    isProcessed = true;
                    time++;
                }
            } else {
                break;
            }
        }
        if (!isProcessed) {
            productsQueue.offer(productsQueue.poll());
            time++;
        }
    }

    private static String getTime() {
        int hours = (time / 3600) % 24;
        int minutes = (time % 3600) / 60;
        int seconds = (time % 3600) % 60;
        DecimalFormat df = new DecimalFormat("00");
        return String.format("%s:%s:%s", df.format(hours), df.format(minutes), df.format(seconds));
    }
}

class Robot {
    public String name;
    public int workTime;
    public int finishingTime;
}
