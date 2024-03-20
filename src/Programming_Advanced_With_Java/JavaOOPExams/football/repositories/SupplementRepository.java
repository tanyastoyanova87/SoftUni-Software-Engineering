package Programming_Advanced_With_Java.JavaOOPExams.football.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
