import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        String outputPath = "./resources/list.ser";
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 11.3, 4.7, 8.1, 12.0, 14.9);

        // serialize
        try (FileOutputStream fos = new FileOutputStream(outputPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(doubles);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // deserialize
        try (FileInputStream fis = new FileInputStream(outputPath);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            List<Double> deserializedDoubles = (List<Double>) ois.readObject();
            System.out.println(deserializedDoubles.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
