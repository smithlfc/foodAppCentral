(function() {
var app=angular.module("regapp");
app.controller("valcontroller",function($scope){
this.password_1flag=true;

$scope.$watch("myspring",function(){
console.log($scope.myspring);	
});



this.dummy=function(){
if(this.user_password == this.user_password_1){
this.password_1flag=false;
}	
else{
this.password_1flag=true;	
}


}
}
//function end here
);
})();

