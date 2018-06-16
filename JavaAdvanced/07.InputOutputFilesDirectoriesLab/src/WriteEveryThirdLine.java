import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "./resources/input.txt";
        String outputPath = "./resources/outputWriteEveryThirdLine.txt";

        // BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
        PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            String line = in.readLine();
            int counter = 1;
            while(line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
