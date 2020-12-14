package abstractions;

import fucntionalInterfaces.Func;

import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface RegistryHandler<T> extends Closeable {

    void set(Func<T> func) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    Collection<T> getAll();

    T getNewInstance();

    void add();
}
