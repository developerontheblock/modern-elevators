package interfaces;

// generic interface (on purpose)
public interface Repository<T> {

    // Access modifier 'public' is redundant for interface methods
    void add(T model);

    T find(T data);
}
