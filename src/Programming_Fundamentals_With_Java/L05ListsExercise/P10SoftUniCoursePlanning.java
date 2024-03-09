package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("course start")) {

            String[] commandSplit = command.split(":");
            String commandFirst = commandSplit[0];
            String lessonTitle = commandSplit[1];
            int indexFirstLesson = schedule.indexOf(lessonTitle);

            if (command.contains("Add")) {
                if (!schedule.contains(lessonTitle)) {
                    schedule.add(lessonTitle);
                }
            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(commandSplit[2]);
                if (!schedule.contains(lessonTitle)) {
                    schedule.add(index, lessonTitle);
                }
            } else if (command.contains("Remove")) {
                if (schedule.contains(lessonTitle)) {
                    int lessonIndex = schedule.indexOf(lessonTitle);
                    String exerciseName = lessonIndex + "-Exercise";
                    boolean hasExercise = lessonIndex != schedule.size() - 1 && schedule.get(lessonIndex + 1).equals(exerciseName);
                    schedule.remove(lessonTitle);

                    if (hasExercise) {
                        schedule.remove(exerciseName);
                    }
                }
            } else if (command.contains("Swap")) {
                String secondLesson = commandSplit[2];
                int indexSecondLesson = schedule.indexOf(secondLesson);

                if (schedule.contains(lessonTitle) && schedule.contains(secondLesson)) {
                    schedule.set(indexFirstLesson, secondLesson);
                    schedule.set(indexSecondLesson, lessonTitle);

                    String exFirstLesson = lessonTitle + "-Exercise";
                    String exSecondLesson = secondLesson + "-Exercise";

                    if (schedule.contains(exFirstLesson)) {
                        schedule.remove(exFirstLesson);
                        schedule.add(schedule.indexOf(lessonTitle) + 1, exFirstLesson);
                    }

                    if (schedule.contains(exSecondLesson)) {
                        schedule.remove(exSecondLesson);
                        schedule.add(schedule.indexOf(secondLesson) + 1, exSecondLesson);
                    }
                }

            } else if (command.contains("Exercise")) {
                if (schedule.contains(lessonTitle)) {
                    int index = schedule.indexOf(lessonTitle);
                    String exerciseName = lessonTitle + "-Exercise";
                    if (!schedule.contains(exerciseName)) {
                        schedule.add(index + 1, exerciseName);
                    }
                }else {
                    schedule.add(lessonTitle);
                    schedule.add(lessonTitle + "-Exercise");
                }

            }
            command = scanner.nextLine();
        }
        int num = 1;
        for (String lesson: schedule) {
            System.out.println(num + "." + lesson);
            num++;
        }
    }
}
