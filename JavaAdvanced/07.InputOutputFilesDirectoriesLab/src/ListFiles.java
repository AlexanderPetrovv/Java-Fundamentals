import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String path = "./resources/Files-and-Streams";

        File rootDir = new File(path);

        if (rootDir.exists()) {
            if (rootDir.isDirectory()) {
                File[] files = rootDir.listFiles();
                if (files == null) {
                    return;
                }
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: %s%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
