package BaSeDeVerDad.Exceptions;

public class NotValidDataException extends RuntimeException{
    public NotValidDataException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}