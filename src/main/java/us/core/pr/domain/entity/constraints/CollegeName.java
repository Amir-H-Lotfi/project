package us.core.pr.domain.entity.constraints;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Name
@Size(min = 5, max = 48)
//@Pattern(regexp = "^[a-zA-Z0-9_.-]*$")
@Pattern(regexp = "^[a-zA-Z0-9]*$")
public @interface CollegeName {}
