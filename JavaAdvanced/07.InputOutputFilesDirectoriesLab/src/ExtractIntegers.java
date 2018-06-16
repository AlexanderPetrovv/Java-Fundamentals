import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "./resources/input.txt";
        String outputPath = "./resources/outputExtractInts.txt";


        try (Scanner scanner = new Scanner(new FileInputStream(inputPath), "UTF-8");
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {
            while(scanner.hasNext()) {
                if(scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
