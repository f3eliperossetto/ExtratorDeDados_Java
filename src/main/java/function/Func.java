package function;

@FunctionalInterface
public interface Func<T> {
    T invoke();
}
