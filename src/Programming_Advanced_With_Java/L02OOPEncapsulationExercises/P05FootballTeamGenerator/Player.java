package Programming_Advanced_With_Java.L02OOPEncapsulationExercises.P05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if (isNotInBounds(endurance)) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Endurance"));
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (isNotInBounds(sprint)) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Sprint"));
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (isNotInBounds(dribble)) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Dribble"));
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (isNotInBounds(passing)) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Passing"));
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (isNotInBounds(shooting)) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Shooting"));
        }
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.dribble + this.passing + this.sprint + this.shooting) / 5.0;
    }
    private boolean isNotInBounds(int number) {
        return number < 0 || number > 100;
    }
}
