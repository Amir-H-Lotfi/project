package us.core.pr.domain.entity.constraints;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Name
@Size(max = 48)
@Pattern(regexp = "^[a-zA-Z]*$")
public @interface PersonName {}
