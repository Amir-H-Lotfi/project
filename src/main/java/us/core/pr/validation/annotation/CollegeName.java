package us.core.pr.validation.annotation;


import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@NotBlank @NotNull @Pattern(regexp = "^[a-zA-Z0-9_.-]*$") @Size
@Documented
@Constraint(validatedBy ={})
@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
//@Pattern(regexp = "^[a-zA-Z0-9]*$")
public @interface CollegeName
{

    @OverridesAttribute(constraint = Size.class, name = "min")
    int min() default 5;

    @OverridesAttribute(constraint = Size.class, name = "max")
    int max() default 48;

    @OverridesAttribute(constraint = Pattern.class, name = "regexp")
    String regexp() default "^[a-zA-Z0-9_.-]*$";

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;
}

