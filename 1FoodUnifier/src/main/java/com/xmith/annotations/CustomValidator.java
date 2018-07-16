package com.xmith.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.xmith.services.UserServices;

public class CustomValidator implements ConstraintValidator<CheckUserExist, String> {

@Autowired
private UserServices userservices;
public void setUserservices(UserServices userservices) {
this.userservices = userservices;
}
	
@Override
public void initialize(CheckUserExist constraintAnnotation) {

}

@Override
public boolean isValid(String value, ConstraintValidatorContext context) {
if(userservices.getUserId(value)==null){
return true;
}
return false;
}

}
