import java.io.Serializable;

public class Course implements Serializable{
    private String name;
    private int studentCount;

    public Course(String name, int studentCount) {
        this.name = name;
        this.studentCount = studentCount;
    }

    public String getName() {
        return this.name;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    @Override
    public String toString() {
        return "Course name: " + this.getName() + "\n" + "Course students: " + this.getStudentCount();
    }
}
