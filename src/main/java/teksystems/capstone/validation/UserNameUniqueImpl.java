package teksystems.capstone.validation;

import teksystems.capstone.database.DAO.UserDAO;
import teksystems.capstone.database.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameUniqueImpl implements ConstraintValidator<UserNameUnique, String> {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void initialize(UserNameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String st, ConstraintValidatorContext constraintValidatorContext) {
        if (st.isEmpty()) {return true;}
        User user = userDAO.findUserByUsername(st);
        return (user == null);
    }
}
