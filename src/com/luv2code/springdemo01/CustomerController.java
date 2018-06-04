package com.luv2code.springdemo01;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class CustomerController {
	
	@RequestMapping("/")
	public String showForm(Model theModel) {
		Customer newCustomer = new Customer();
		theModel.addAttribute("customer", newCustomer);
		return "show-customer-form";
	}
	
	@RequestMapping("/processform")
	public String processForm(@Validated @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) {
			return "show-customer-form";
		}
		else
			return "confirm-customer";
	}

	@InitBinder
	public void initBinderFx(WebDataBinder theWebDataBinder) {
		StringTrimmerEditor theStringTrimmerEditor = new StringTrimmerEditor(true);
		theWebDataBinder.registerCustomEditor(String.class,theStringTrimmerEditor);
	}
}
