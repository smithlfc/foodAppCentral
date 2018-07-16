package com.xmith.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented()
@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CustomValidator.class)
public @interface CheckUserExist {
String message() default "User already exist";
Class<?>[] groups() default { };
Class<? extends Payload>[] payload() default { };
}
