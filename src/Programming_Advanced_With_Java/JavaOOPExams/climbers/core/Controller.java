package Programming_Advanced_With_Java.JavaOOPExams.climbers.core;

public interface Controller {
    String addClimber(String type, String climberName);

    String addMountain(String mountainName, String... peaks);

    String removeClimber(String climberName);

    String startClimbing(String mountainName);

    String getStatistics();

}
