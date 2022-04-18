package teksystems.capstone.formbean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import teksystems.capstone.validation.UserNameUnique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Data
public class RegisterFormBean {
    private Integer id;

    @NotBlank(message = "Username is required")
    @UserNameUnique(message = "Username is already in use")
    @Length(min=8, max=15, message="Username must be between 8 and 15 characters")
    private String username;

    @Length(min=3, max=30, message="First Name must be between 3 and 30 characters")
    @NotBlank(message="First Name is required")
    private String firstName;

    @Length(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    @NotBlank(message="Last Name is required")
    private String lastName;

    @Length(min=8, max=20, message="Password must be between 8 and 20 characters")
    @NotBlank(message="Password is required")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){3,32}$" , message = "Password invalid: one Uppercase, one lower case, one digit, and one special character required")
    private String password;

    @NotBlank(message="Confirm password is required")
    private String confirmPassword;
}