package delegators;

public interface Predicate<T> {
    boolean invoke(T param);
}
