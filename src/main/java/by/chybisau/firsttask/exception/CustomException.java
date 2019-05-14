package by.chybisau.firsttask.exception;

/**
 * Created by Maksim Chybisau on 02/05/19.
 * @version 0.0.2
 */
public class CustomException extends Exception {

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String cause, String message) {
        super(message);
    }
}
