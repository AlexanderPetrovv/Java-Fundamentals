package StudentsJoinedToSpecialties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"Students:".equals(line)) {
            String[] tokens = line.split("\\s+");
            String specialtyNameFirst = tokens[0];
            String specialtyNameSecond = tokens[1];
            String facultyNumber = tokens[2];

            String fullSpecialty = specialtyNameFirst + " " + specialtyNameSecond;
            StudentSpecialty studentSpecialty = new StudentSpecialty(fullSpecialty, facultyNumber);
            studentSpecialties.add(studentSpecialty);

            line = reader.readLine();
        }

        line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String facultyNumber = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];

            String fullName = firstName + " " + lastName;
            Student student = new Student(fullName, facultyNumber);
            students.add(student);

            line = reader.readLine();
        }

        students.sort(Comparator.comparing(Student::getStudentName));

//        List<String> matched = new ArrayList<>();

        students.stream()
                .forEach(student -> studentSpecialties.stream()
                        .forEach(specialty -> {
                            if (specialty.getFacultyNumber().equals(student.getFacultyNumber())) {
                                System.out.println((String.format("%s %s %s",
                                        student.getStudentName(),
                                        student.getFacultyNumber(),
                                        specialty.getSpecialtyName())));
                            }
                        }));

//        students.stream()
//                .flatMap(student -> studentSpecialties.stream()
//                        .filter(specialty -> {
//                            if (specialty.getFacultyNumber().equals(student.getFacultyNumber())) {
//                                matched.add(String.format("%s %s %s",
//                                        student.getStudentName(),
//                                        student.getFacultyNumber(),
//                                        specialty.getSpecialtyName()));
//                            }
//
//                            return specialty.getFacultyNumber().equals(student.getFacultyNumber());
//                        }));
    }
}

class StudentSpecialty {
    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}

class Student {
    private String studentName;
    private String facultyNumber;

    public Student(String studentName, String facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}