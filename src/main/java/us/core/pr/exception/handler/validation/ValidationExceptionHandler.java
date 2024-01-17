package us.core.pr.exception.handler.validation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.*;

@ControllerAdvice
public class ValidationExceptionHandler
        implements Serializable
{
    // TODO need to modify
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> constraintViolationExceptionHandler(ConstraintViolationException exception)
    {
        Map<String, String> errors = new HashMap<>();
        exception.getConstraintViolations().forEach(
                constraintViolation ->
                {
                    String property = constraintViolation.getPropertyPath().toString();
                    String errorMessage = constraintViolation.getMessage();
                    errors.put(property, errorMessage);
                }
        );
        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException exception)
    {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error ->
                {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                }
        );

        return errors;
    }
}
