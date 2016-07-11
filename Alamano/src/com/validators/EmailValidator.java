package com.validators;

import javax.faces.application.FacesMessage;
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

	  //UIInput uiInputemail = (UIInput) component.getAttributes()
		//.get("email");
	  //String email2 = uiInputemail.getSubmittedValue()
		//.toString();

	  // Let required="true" do its job.
	  if (email == null || email.isEmpty() //|| confirmPassword == null
		//|| confirmPassword.isEmpty()
		) {
			return;
	  }
	  DataBaseHelper dbHelper = new DataBaseHelper();
	  if (dbHelper.query("Select * from usuario u where u = email") != null) {
		  //uiInputemail.setValid(false);
		throw new ValidatorException(new FacesMessage(
			"This email is already exist."));
	  }
	  
	  //select u.email from Usuario u where u.email = this.email

	}
}
