import java.io.*;

public class CopyBytes {
    private static final int ASCII_CODE_SPACE = 32;
    private static final int ASCII_CODE_NEW_LINE = 10;

    public static void main(String[] args) {
        String inputPath = "./resources/input.txt";
        String outputPath = "./resources/outputCopyBytes.txt";

        try (InputStream fis = new FileInputStream(inputPath);
             OutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = 0;
            while ((oneByte = fis.read()) >= 0) {
                if (ASCII_CODE_NEW_LINE == oneByte || ASCII_CODE_SPACE == oneByte) {
                    fos.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fos.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
