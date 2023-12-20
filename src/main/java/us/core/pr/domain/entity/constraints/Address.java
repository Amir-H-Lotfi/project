package us.core.pr.domain.entity.constraints;

import jakarta.validation.constraints.*;

@Name
@Size(max = 128)
//@Pattern(regexp = "([A-Za-z0-9\\-\\_]+)")
@Pattern(regexp = "([A-Za-z\\-]+)")
public @interface Address {}
