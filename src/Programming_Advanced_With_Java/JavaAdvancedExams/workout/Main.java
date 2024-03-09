package Programming_Advanced_With_Java.JavaAdvancedExams.workout;

public class Main {
    public static void main(String[] args) {

        Workout workout = new Workout("strength", 3);

        Exercise exercise = new Exercise("squats", "legs", 50);
        System.out.println(exercise);

        workout.addExercise(exercise);

        System.out.println(workout.removeExercise("Bench Press", "arms"));
        System.out.println(workout.removeExercise("squats", "legs"));

        Exercise secondExercise = new Exercise("Deadlift", "back", 50);
        Exercise thirdExercise = new Exercise("Barbell Curl", "biceps", 25);

        workout.addExercise(secondExercise);
        workout.addExercise(thirdExercise);

        System.out.println(workout.getExercise("Deadlift", "back"));

        Exercise mostBurned = workout.getMostBurnedCaloriesExercise();
        System.out.println(mostBurned);

        System.out.println(workout.getExerciseCount());

        System.out.println(workout.getStatistics());

    }
}
