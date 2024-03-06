package az.edu.coders.eventsphere.security.base;

public interface TokenGenerator<T> {
    String generate(T obj);
}
