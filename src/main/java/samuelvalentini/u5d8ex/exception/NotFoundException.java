package samuelvalentini.u5d8ex.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Elemento non presente nel database: " + message);
    }
}
