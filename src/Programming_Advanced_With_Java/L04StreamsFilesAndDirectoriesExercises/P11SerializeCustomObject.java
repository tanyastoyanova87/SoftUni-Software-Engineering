package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;
import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) {

        Course course = new Course("Java Advanced", 100);

        String path = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            objectOutputStream.writeObject(course);
            Object deserializedCourse = objectInputStream.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
