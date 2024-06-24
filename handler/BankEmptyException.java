package sobes.handler;

public class BankEmptyException extends RuntimeException {

    public BankEmptyException (String message) {
        super(message);
    }
}
