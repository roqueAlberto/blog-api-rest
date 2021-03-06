package com.blog.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PostImageValidation.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageUrl {
	
	String message() default "{El URL no hace referencia a una imagen}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
