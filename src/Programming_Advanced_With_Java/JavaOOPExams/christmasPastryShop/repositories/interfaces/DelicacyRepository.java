package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.repositories.interfaces;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);
}
