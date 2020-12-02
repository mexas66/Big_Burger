package fr.greta.java.generic.exception;

public class RepositoryException extends Throwable {
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Exception cause) {
        super(message, cause);
    }
}
