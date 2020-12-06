package functionals;

@FunctionalInterface
public interface Func<T> {
    T invoke();
}
