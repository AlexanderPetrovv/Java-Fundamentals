import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) {
        String dirPath = "./resources/Exercises Resources";
        String outputPath = "./resources/outputGetFolderSize.txt";
        File root = new File(dirPath);
        Deque<File> files = new ArrayDeque<>();

        if (root.exists()) {
            files.offer(root);
            int size = 0;
            while(!files.isEmpty()) {
                File currentFile = files.poll();
                if (currentFile.isDirectory()) {
                    File[] nestedFiles = currentFile.listFiles();
                    if (nestedFiles != null) {
                        for (File nestedFile : nestedFiles) {
                            if (!nestedFile.isDirectory()) {
                                size += nestedFile.length();
                            } else {
                                files.offer(nestedFile);
                            }
                        }
                    }
                } else {
                    size += currentFile.length();
                }
            }

            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputPath)))){
                writer.println("Folder size: " + size);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
