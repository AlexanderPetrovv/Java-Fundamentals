import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "./resources/input.txt";
        String outputPath = "./resources/outputAllCaps.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            String line = in.readLine();
            while (line != null) {
                out.println(line.toUpperCase());
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
