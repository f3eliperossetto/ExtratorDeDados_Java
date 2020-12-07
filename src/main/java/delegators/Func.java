package delegators;

@FunctionalInterface
public interface Func<T> {
    T invoke();
}
