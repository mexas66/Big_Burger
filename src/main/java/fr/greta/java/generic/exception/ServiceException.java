package fr.greta.java.generic.exception;

public class ServiceException extends Throwable {
    public ServiceException(Throwable e) {
        super(e);
    }
}
