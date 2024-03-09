package Programming_Advanced_With_Java.JavaAdvancedExams.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.data.size() < this.capacity) {
            if (this.data.contains(student)) {
                return "P03StudentSystem.Student is already in the hall.";
            }
            this.data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "The hall is full.";
    }

    public String remove(Student student) {
        if (!this.data.contains(student)) {
            return "P03StudentSystem.Student not found.";
        }
        this.data.remove(student);
        return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        for (Student student1 : this.data) {
            if (student1.getFirstName().equals(firstName) && student1.getLastName().equals(lastName)) {
                student = student1;
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d%n", this.data.size()));
        for (Student student : this.data) {
            sb.append(String.format("%s%n", student.toString()));
        }
        return sb.toString();
    }
}
