import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("./resources/inputSortLines.txt");
        Path outputPath = Paths.get("./resources/outputSortLines.txt");
        // BufferedReader reader = Files.newBufferedReader(inputPath)

        try {
            List<String> lines = Files.readAllLines(inputPath);
            Collections.sort(lines);
            Files.write(outputPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
