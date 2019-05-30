package aoizora.usecase.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException(final String message) {
        super(message);
    }
}
