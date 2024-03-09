package Programming_Advanced_With_Java.JavaAdvancedExams.university;

public class Main {
    public static void main(String[] args) {

        University university = new University(10);
// Initialize entities
        Student student = new Student("John", "Smith", "Astrology");
        Student studentTwo = new Student("Anna", "Cameron", "Geometry");
        Student studentThree = new Student("Samy", "Johnson", "Algebra");
        Student studentFour = new Student("Rihanna", "Fenty", "Music");
        Student studentFive = new Student("Ellie", "Goulding", "Music");
// Print P03StudentSystem.Student
        System.out.println(student);

        String register = university.registerStudent(student);
        System.out.println(university.getCapacity()); // 10
        System.out.println(register); // Added student John Smith
        String registerTwo = university.registerStudent(studentTwo);
        String registerThree = university.registerStudent(studentThree);
        String registerFour = university.registerStudent(studentFour);
// Dismiss P03StudentSystem.Student
        String dismissed = university.dismissStudent(student);
        System.out.println(dismissed); // Removed student John Smith
        String dismissedTwo = university.dismissStudent(studentFive);
        System.out.println(dismissedTwo); // P03StudentSystem.Student not found
// Get P03StudentSystem.Student
        System.out.println(university.getStudent("Rihanna", "Fenty"));
// P03StudentSystem.Student: Rihanna Fenty, Music
        System.out.println(university.getStudentCount()); // 3
        System.out.println(university.getStatistics());

    }
}
