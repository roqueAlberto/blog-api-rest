package com.blog.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostImageValidation implements ConstraintValidator<ImageUrl, String>{

	@Override
    public void initialize(ImageUrl imageUrl) {
    }
	
	@Override
	public boolean isValid(String image, ConstraintValidatorContext context) {
		return (image.contains("png") || image.contains("jpg"));
	}

}
