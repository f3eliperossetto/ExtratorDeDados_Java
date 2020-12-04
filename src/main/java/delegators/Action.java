package delegators;

public interface Action<T> {
    void invoke(T param);
}
