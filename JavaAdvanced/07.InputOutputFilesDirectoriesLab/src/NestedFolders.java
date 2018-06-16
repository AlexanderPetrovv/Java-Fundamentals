import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "./resources/Files-and-Streams";
        File root = new File(path);
        Deque<File> dirs = new ArrayDeque<>();

        if (root.exists()) {
            dirs.offer(root);
            int count = 1;
            while (!dirs.isEmpty()) {
                File current = dirs.poll();
                File[] nestedFiles = current.listFiles();
                if (nestedFiles == null) {
                    return;
                }
                for (File nestedFile : nestedFiles) {
                    if (nestedFile.isDirectory()) {
                        dirs.offer(nestedFile);
                        count++;
                    }
                }
                System.out.println(current.getName());
            }
            System.out.println(count + " folders");
        }
    }
}
