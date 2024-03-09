package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = fileInputStream.read();
        }

    }
}
