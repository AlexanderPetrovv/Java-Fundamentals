import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        String path = "./resources/object.ser";

        Cube cube = new Cube("green", 15.3d, 12.4d, 3d);

        // Serialization
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            Cube currentCube = (Cube) ois.readObject();
            System.out.println(currentCube);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
