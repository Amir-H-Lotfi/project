package us.core.pr.validation.validator.jsr380;

import us.core.pr.validation.annotation.CollegeName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.Serializable;

public class JSR380CollegeNameValidator
implements ConstraintValidator<CollegeName , Object[]>,Serializable
{
    @Override
    public void initialize(CollegeName constraintAnnotation)
    {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext)
    {
        return false;
    }
}
