package us.core.pr.domain.entity.constraints;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Name
@Size(max = 48)
@Pattern(regexp = "^[a-zA-Z]*$")
public @interface PersonName {}
