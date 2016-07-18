package com.validators;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import db.admin.DataBaseHelper;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator{
	@Override
	public void validate(FacesContext context, UIComponent component,
		Object value) throws ValidatorException {

	  String email = value.toString();

	  if (email == null || email.isEmpty()){
			return;
	  }
	  DataBaseHelper dbHelper = new DataBaseHelper();
	  //String result = dbHelper.query("Select count(*) as cant from usuario u where u.email ='" + email + "';");
	  String result = dbHelper.query("Select * from usuario u where u.email ='" + email + "';");
	  if (result != null) {
		  //uiInputemail.setValid(false);
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "This email is already exist.",
			"This email is already exist."));
	  }

	}
}
