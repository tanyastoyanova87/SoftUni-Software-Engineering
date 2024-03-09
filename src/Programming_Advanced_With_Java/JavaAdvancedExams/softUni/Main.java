package Programming_Advanced_With_Java.JavaAdvancedExams.softUni;

public class Main {
    public static void main(String[] args) {

        SoftUni softUni = new SoftUni(7);

        Student student = new Student("Boryana", "Dimitrova", "JavaScript");
        Student studentTwo = new Student("Joana", "Jonkova", "Java");
        Student studentThree = new Student("Desislava", "Topuzakova", "FundamentalsInMathematics");
        Student studentFour = new Student("Alex", "Raykova", "Python");
        Student studentFive = new Student("Rosica", "Nenova", "C#");

        String adding = softUni.insert(student);
        System.out.println(adding); // Added student Boryana Dimitrova.
        String adding1 = softUni.insert(studentTwo);
        System.out.println(adding1); // Added student Joana Jonkova.
        softUni.insert(studentThree);
        softUni.insert(studentFour);

        String removal = softUni.remove(studentTwo);

        System.out.println(removal); // Removed student Joana Jonkova.
        String removal1 = softUni.remove(studentFive);
        System.out.println(removal1); // P03StudentSystem.Student not found.

        System.out.println(softUni.getStudent("Alex", "Raykova")); // P03StudentSystem.Student: Alex Raykova, Best Course – Python

        System.out.println(softUni.getStatistics());

    }
}
