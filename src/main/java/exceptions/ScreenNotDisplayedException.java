package exceptions;

public class ScreenNotDisplayedException extends RuntimeException {

    public ScreenNotDisplayedException(String message) {
        super(message);
    }
}
