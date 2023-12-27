package us.core.pr.domain.entity.constraints;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Name
@Size(max = 128)
//@Pattern(regexp = "([A-Za-z0-9\\-\\_]+)")
@Pattern(regexp = "([A-Za-z\\-]+)")
public @interface Address {}
