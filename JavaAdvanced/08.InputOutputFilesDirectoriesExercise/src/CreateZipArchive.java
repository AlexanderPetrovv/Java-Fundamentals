import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String firstFilePath = "./resources/input.txt";
        String secondFilePath = "./resources/text.txt";
        String thirdFilePath = "./resources/words.txt";
        String zipPath = "./resources/files.zip";

        byte[] buffer = new byte[1024];
        try (FileInputStream fis1 = new FileInputStream(firstFilePath);
             FileInputStream fis2 = new FileInputStream(secondFilePath);
             FileInputStream fis3 = new FileInputStream(thirdFilePath);
             ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
            int len;
            zos.putNextEntry(new ZipEntry("input.txt"));
            while ((len = fis1.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("text.txt"));
            while ((len = fis2.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("words.txt"));
            while ((len = fis3.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
