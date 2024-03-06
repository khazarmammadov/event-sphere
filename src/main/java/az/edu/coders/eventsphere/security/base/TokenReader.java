package az.edu.coders.eventsphere.security.base;

public interface TokenReader <T> {
    T read(String token);
}
