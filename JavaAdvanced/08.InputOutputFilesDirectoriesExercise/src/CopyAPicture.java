import java.io.*;

public class CopyAPicture {
    public static void main(String[] args) {
        String picPath = "./resources/trollface.jpg";
        String copyPath = "./resources/outputCopyAPicture.jpg";

        try (InputStream input = new FileInputStream(picPath);
             OutputStream output = new FileOutputStream(copyPath)){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
