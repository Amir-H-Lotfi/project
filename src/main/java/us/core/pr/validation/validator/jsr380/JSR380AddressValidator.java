package us.core.pr.validation.validator.jsr380;

import us.core.pr.validation.annotation.Address;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.Serializable;

public class JSR380AddressValidator
        implements ConstraintValidator<Address, Object[]>, Serializable
{
    @Override
    public void initialize(Address constraintAnnotation)
    {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext)
    {
        return false;
    }
}
