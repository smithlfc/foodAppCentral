<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html ng-app="homeapp">
<head>
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



<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">FoodUnifier</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item active">
       <a class="nav-link" href="#">Link1</a> 
      </li>
      <li class="nav-item active">
       <a class="nav-link" href="#">Link2</a> 
      </li>
	  
	  <li class="nav-item active">
       <a class="nav-link" href="#">Link2</a> 
      </li>
	  
	  <li>
	   <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
	  </li>	  
    </ul>
 	
    <form id="logout"  action='/logout' method="post">
    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}">
    <input id="lbutton" class="nav-link btn btn-primary"   type="submit" value="logout">
    </form>	
 
  </div>
  
</nav>

</div>


<div class="container">

 <div class="row">
 
 <div class="col-sm">
<br><br><br>
</div>

</div>


 <div class="row" style="text-align:center">
 
 <div class="col-md-3" style="text-align:center">
 
 </div>
 
 <div class="col-md-3" style="text-align:center;">

 <div class="card" style="width: 18rem;">
   <img class="card-img-top" src="C:\Users\Dena\Desktop\nisith\Payment.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
 
 </div>

 <div class="col-md-3" style="text-align:center">
 
  <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
 
 </div>
 <div class="col-md-3" style="text-align:center">
 
 </div>
 
 </div>
<!-- 2nd card -->
 <div class="row" style="text-align:center">
 
 <div class="col-md-3" style="text-align:center">
 
 </div>
 
 <div class="col-md-3" style="text-align:center;">

 <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
 
 </div>

 <div class="col-md-3" style="text-align:center">
 
  <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
 
 </div>
 <div class="col-md-3" style="text-align:center">
 
 </div>
 
 </div>
<!-- 3rd card -->
 <div class="row" style="text-align:center">
 
 <div class="col-md-3" style="text-align:center">
 
 </div>
 
 <div class="col-md-3" style="text-align:center;">

 <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="Payment.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
 
 </div>

 <div class="col-md-3" style="text-align:center">
 
  <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
 
 </div>
 <div class="col-md-3" style="text-align:center">
 
 </div>
 
 </div>
 
 
 
</div>

 


</div>











</body>
</html>
