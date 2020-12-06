package abstractions;

import functionals.Func;

import java.util.List;

public interface RegistryHandler<T> {
    void set(Func<T> func);

    List<T> getAll();

    T getNewInstance();

    void add();

    void dispose();
}
