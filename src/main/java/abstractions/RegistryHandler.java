package abstractions;

import fcuntionalInterfaces.Func;

import java.util.Collection;

public interface RegistryHandler<T> {

    void set(Func<T> func);

    Collection<T> getAll();

    T getNewInstance();

    void add();

    void dispose();
}
