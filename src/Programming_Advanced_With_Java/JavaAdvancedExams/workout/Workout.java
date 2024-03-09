package Programming_Advanced_With_Java.JavaAdvancedExams.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise mostBurnedCalories = null;
        for (Exercise exercise : this.exercises) {
            if (mostBurnedCalories == null) {
                mostBurnedCalories = exercise;
            } else  {
                if (exercise.getBurnedCalories() > mostBurnedCalories.getBurnedCalories()) {
                    mostBurnedCalories = exercise;
                }
            }
        }
        return mostBurnedCalories;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", this.type));
        for (Exercise exercise : this.exercises) {
            sb.append(String.format("%s%n", exercise));
        }
        return sb.toString();
    }
}
