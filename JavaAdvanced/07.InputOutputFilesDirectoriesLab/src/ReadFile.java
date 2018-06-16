import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "./resources/input.txt";

        FileInputStream fis = null;
        try {
             fis = new FileInputStream(path);
            int oneByte = fis.read();
            while(oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
