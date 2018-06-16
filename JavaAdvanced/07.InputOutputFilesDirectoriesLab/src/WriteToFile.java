import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "./resources/input.txt";
        String outputPath = "./resources/outputWriteToFile.txt";

        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try(InputStream fis = new FileInputStream(inputPath);
            OutputStream fos = new FileOutputStream(outputPath)){
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {

        }
    }
}
