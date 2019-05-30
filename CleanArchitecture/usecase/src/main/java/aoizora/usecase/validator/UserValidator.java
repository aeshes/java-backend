package aoizora.usecase.validator;

import aoizora.entity.User;
import aoizora.usecase.exception.UserValidationException;

public class UserValidator {

    public static void validateCreateUser(final User user) {
        if (user == null)
            throw new UserValidationException("User should not be null");
    }

    private UserValidator() {}
}
