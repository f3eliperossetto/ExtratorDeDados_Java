package abstractions;

import fcuntionalInterfaces.Func;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface RegistryHandler<T> {

    void set(Func<T> func) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    Collection<T> getAll();

    T getNewInstance();

    void add();

    void dispose();
}
