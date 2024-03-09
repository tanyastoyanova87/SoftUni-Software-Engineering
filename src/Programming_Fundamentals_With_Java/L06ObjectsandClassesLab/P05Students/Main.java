package Programming_Fundamentals_With_Java.L06ObjectsandClassesLab.P05Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] studentInfo = line.split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);
            String hometown = studentInfo[3];

            boolean exists = false;
            for (Student student : students) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    student.setAge(age);
                    student.setHometown(hometown);

                    exists = true;
                    break;
                }
            }
            if (!exists) {
                Student student = new Student(firstName, lastName, age, hometown);

                students.add(student);
            }

            line = scanner.nextLine();
        }
        String city = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(city)) {
                System.out.println(student.getDetails());
            }
        }
    }
}
