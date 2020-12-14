package function;

@FunctionalInterface
public interface Predicate<T> {
    boolean invoke(T param);
}
