package com.validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import db.admin.DataBaseHelper;

@FacesValidator(value = "termsAndConditionsValidator")
public class TermsAndCondValidator implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent component,
		Object value) throws ValidatorException {

		
	  Boolean termsAndCond =  ((Boolean)value).booleanValue();

	  if (termsAndCond == null){
			return;
	  }
	  if (termsAndCond == false) {
		  //uiInputemail.setValid(false);
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "You must accept terms and conditions webon",
				"You must accept terms and conditions webon"));
	  }

	}
}
