package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
