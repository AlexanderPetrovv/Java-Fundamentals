import java.io.*;

public class SerializeCustomObjectCourse {
    public static void main(String[] args) {
        String output = "./resources/course.ser";

        Course course = new Course("Algorithms & Data Structures", 123);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(output))) {
            oos.writeObject(course);
            Course deserCourse = (Course) ois.readObject();
            System.out.println(deserCourse.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
