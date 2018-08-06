<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html ng-app="homeapp">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script type="text/javascript" src="../../sweb/resources/home/myapp.js"></script>
<script type="text/javascript" src=../../sweb/resources/home/services.js></script>
<script type="text/javascript" src="../../sweb/resources/home/controller.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</head>
<body ng-controller="controller as c">
<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">FoodApp</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>


  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" >ManageAccounts <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">ManageDishes</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          More
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">SetMpin</a>
          <a class="dropdown-item" href="#">ChangeMpin</a>
         </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">ViewOrders</a>
      </li>
      <li>
       <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
      </li>
    </ul>
   
  </div>
  
 <form id="logout"  action="<c:url value="/logout"/>" method="post">
<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}">
<input id="lbutton" class="btn btn-secondary" type="submit" value="logout" >
</form>
  
</nav>
<!-- Nav bar end -->
<div>
<span ng-init="c.tokenReceived='${webtoken}'"></span>
</div>

<div class="container">
  <div class="row">
    <div class="col bg-light">
      <input type="button" value="getAccounts" ng-click="c.getAccounts()" class="btn btn-info col-lg-4">
    </div>
    <div class="col">
       <input type="button" value="AddAccount" ng-click="c.getAccpvds()" class="btn btn-info col-lg-4">
 
 <div ng-hide="c.hideaddacc">
 <br>

 <br>
 <div class="dropdown" >
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Dropdown link
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink" >
  <span ng-repeat="apv in c.listpvds">
    <li class="dropdown-item" ng-click="c.getAccountsofBanks($index)" >{{apv}}</li>
   </span> 
  </div>
</div> 
<br>

<div ng-show="c.acclistpsp">
listaccounts
</div> 
  
 </div>      
       
       
    </div>
  </div>
<!-- write logic for add also -->





<br>

<div class="container">
  <div class="row">
  
    <div class="col col-lg-6">
      <ul class="list-group align-middle">
      <div ng-repeat="x in c.accountlist">
   <li class="list-group-item" ng-click="c.showAccDetails($index)" >{{x.account_no}}</li>
   </div>
  </ul>
    </div>
    
    <div  class="col bg-light" ng-hide=c.showimage>
     <div class="media" >
  <img class="mr-3" src="{{c.AccountShow.httimage}}" alt="Generic placeholder image">
  <div class="media-body">
    <h5 class="mt-0">AccountInfo</h5>
   <span ng-if="1==c.AccountShow.primary"><b>PrimaryAccount</b></span><br>
   Account Number:<b>{{c.AccountShow.account_no}}</b><br>
   IFSC Code     :<b>{{c.AccountShow.ifsc_no}}</b><br>
   Accout Type   :<b>{{c.AccountShow.account_type}}</b><br>  
  </div>
</div>
    </div>
    <!-- coldiv -->
  </div>



</div>









</body>
</html>
