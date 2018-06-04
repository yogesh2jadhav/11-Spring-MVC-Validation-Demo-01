/**
 * 
 */
package com.luv2code.springdemo01.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yogesh
 *
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	public String prefix;
	
	@Override
	public void initialize(CourseCode courseCodeAnnotation) {
		this.prefix=courseCodeAnnotation.Value();
	}
	
	@Override
	public boolean isValid(String courseNamefromFE, ConstraintValidatorContext constraintValidatorContext) {
		// TODO Auto-generated method stub
		boolean result;
		
		if(courseNamefromFE!=null) {
			result=courseNamefromFE.startsWith(prefix);
		}else {
			result=true;
		}
			
		return result;
	}

 

}
