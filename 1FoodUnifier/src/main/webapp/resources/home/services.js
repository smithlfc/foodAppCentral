(function(){
var homeapp=angular.module("homeapp");
homeapp.service("service", function($http) {
var self =this;

this.getDataService=function(token){
	
var req={
method:'GET',
url:'http://localhost:8080/sweb/all/secure/getname',
headers: {
'Authorization':token}				
};

console.log("in sercice "+token)
var promise=$http(req);

return promise;

}


	
})
})();