package com.luv2code.springdemo01;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springdemo01.validation.CourseCode;

public class Customer {

	public String firstName;
	
	@NotNull(message="Can't be null")
	@Size(min=3, message="Enter More then 3 Char")
	public String lastName;

	@NotNull(message="This can't be null")
	@CourseCode(Value="LUV", message="Course Name should start with LUV")
	public String courseName;
	
	
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
