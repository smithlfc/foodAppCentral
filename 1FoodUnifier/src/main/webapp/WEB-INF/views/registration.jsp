<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="regapp">
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script type="text/javascript" src="../../sweb/resources/registration/myapp.js"></script>
<script type="text/javascript" src=../../sweb/resources/registration/services.js></script>
<script type="text/javascript" src="../../sweb/resources/registration/controller.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
</head>
<body ng-controller="valcontroller as c">
<nav class="navbar navbar-expand-lg navbar-light bg-light"></nav>

<form:form name="regform" modelAttribute="userDetails" action="/sweb/setReg" method="post">
<div class="col-5">

<div class="form-group" class="row">
<label class="font-weight-bold" for="exampleInputEmail1">First Name</label>
<form:input name="user_first_name" type="text" class="form-control"  aria-describedby="fnamehelp" placeholder="Enter First Name" ng-minlength="3"  ng-model="c.user_first_name" path="user_first_name"/> 
<small ng-show="regform.user_first_name.$dirty && regform.user_first_name.$invalid"  class="text-danger">Invalid user name</small>
<small ng-show="regform.$pristine"  class="text-danger"> <form:errors path="user_first_name"/> </small>
</div>

<div class="form-group" class="row">
<label class="font-weight-bold" for="exampleInputEmail1">Last Name</label>
<form:input name="user_last_name" type="text" class="form-control"  aria-describedby="lnamehelp" placeholder="Enter Last Name" ng-minlength="3" ng-model="c.user_last_name" path="user_last_name"/>
<small  ng-show="regform.user_last_name.$dirty && regform.user_last_name.$invalid" class="text-danger">Invalid user last name</small> 
<small  ng-show="regform.$pristine" class="text-danger">  <form:errors path="user_last_name"/> </small>
</div>

<div class="form-group" class="row">
<label class="font-weight-bold" for="exampleInputEmail1">Age</label>
<form:input  name="user_age" type="number" class="form-control"  aria-describedby="agehelp" placeholder="Enter age" min="18" max="100" ng-model="c.user_age" path="user_age"/> 
<small  ng-show="regform.user_age.$dirty && regform.user_age.$invalid"  class="text-danger">Invalid age</small> 
<small ng-show="regform.$pristine" class="text-danger">  <form:errors path="user_age"/> </small>
</div>

<div class="form-group" class="row">
<label class="font-weight-bold" for="exampleInputEmail1">Email address</label>
<form:input  type="email" name="user_email" class="form-control"  aria-describedby="emailHelp" placeholder="Enter email" ng-model="c.user_email" path="user_email"/>
<small  ng-show="regform.user_email.$dirty && regform.user_email.$invalid"  class="text-danger">Invalid email</small> 
<small ng-show="regform.$pristine"  class="text-danger">  <form:errors path="user_email"/> </small>
</div>

<div class="form-group" class="row">
<label class="font-weight-bold" for="exampleInputPassword1">Password</label>
<form:input name="user_password" type="password" class="form-control"  placeholder="Password" ng-model="c.user_password" ng-minlength="3" path="user_password"/>
<small ng-show="regform.user_password.$dirty && regform.user_password.$invalid"  class="text-danger">Invalid too easy</small>
<small ng-show="regform.$pristine"  class="text-danger">  <form:errors path="user_password"/></small>
</div>

<div class="form-group" class="row" ng-show="regform.user_password.$dirty && regform.user_password.$valid"">
<label class="font-weight-bold" for="exampleInputPassword1">Again Password</label>
<input  name="user_password_1" type="password" class="form-control"  placeholder="Password" ng-model="c.user_password_1" ng-change="c.dummy()"  ng-minlength="3" />
<small ng-show="c.password_1flag && regform.user_password_1.$dirty"   id="passwordHelpInline" class="text-danger">Password re-entered is wrong</small><br>
</div>

<button type="submit" class="btn btn-primary" class="row" ng-disabled="!(regform.$valid && regform.$dirty && regform.user_password_1.$dirty && regform.user_password_1.$valid)">Submit</button>

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form:form>


</body>
</html>