
(function(){
var app=angular.module("app");

app.service("dummyservice", function($http) {
	var self=this;
	
	self.getdatadummy=function (){
		self.promise=$http({
			method:'GET',
			url:'http://localhost:8080/sweb/all/secure/getname',
			headers:{'Authorization': '1234567'}
			
			
		});
		
		
	return 	self.promise;
	};
	
	
	
	

	
	
});})();