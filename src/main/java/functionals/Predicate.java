package functionals;

@FunctionalInterface
public interface Predicate<T> {
    boolean invoke(T param);
}
