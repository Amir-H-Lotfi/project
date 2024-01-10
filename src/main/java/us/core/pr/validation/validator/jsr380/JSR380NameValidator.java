package us.core.pr.validation.validator.jsr380;

import us.core.pr.validation.annotation.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.Serializable;

public class JSR380NameValidator
        implements ConstraintValidator<Name, Object[]>, Serializable
{
    @Override
    public void initialize(Name constraintAnnotation)
    {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext)
    {
        return false;
    }
}
