package teksystems.capstone.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SongNameUniqueImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SongNameUnique {

    String message() default "{SongNameUnique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
