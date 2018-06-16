import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "./resources/inputLineNumbers.txt";
        String outputPath = "./resources/outputLineNumbers.txt";

        Path inPath = Paths.get(inputPath);
        Path outPath = Paths.get(outputPath);

        try {
            List<String> lines = Files.readAllLines(inPath);
            List<String> modifiedLines = new ArrayList<>();
            int counter = 0;
            for (String line : lines) {
                counter++;
                modifiedLines.add(counter + ". " + line);
            }
            Files.write(outPath, modifiedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
