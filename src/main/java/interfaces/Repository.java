package interfaces;

// generic interface (on purpose)
public interface Repository<T> {

    // TODO: base interface
    void add(T model);
    T find(T data);
}
