package delegators;

@FunctionalInterface
public interface Action<T> {
    void invoke(T param);
}
