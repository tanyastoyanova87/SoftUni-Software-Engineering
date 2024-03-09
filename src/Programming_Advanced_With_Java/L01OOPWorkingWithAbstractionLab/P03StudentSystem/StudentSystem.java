package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionLab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {

    }

    public Map<String, Student> getRepo() {
        if (this.repo == null) {
            this.repo = new HashMap<>();
        }
        return this.repo;
    }

    public void ParseCommand(String[] args) {
        switch (args[0]) {
            case "Create":
                Student student = this.Create(args);
                this.getRepo().putIfAbsent(student.getName(), student);
                break;
            case "Show":
                String name = args[1];
                student = this.getRepo().get(name);
                if (student != null) {
                    String show = this.Show(student);
                    System.out.println(show);
                }
                break;
        }
    }

    public Student Create(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        return new Student(name, age, grade);
    }

    public String Show(Student student) {
        String view = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }
        return view;
    }
}
