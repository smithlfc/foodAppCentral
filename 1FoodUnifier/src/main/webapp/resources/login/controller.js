(function() {
var app=angular.module("app");
app.controller("controller",controller);


function controller(dummyservice){

     var  self=this;	
     self.commenresponse;

     self.call=function(){
		
		
		var promise=dummyservice.getdatadummy();
		
		promise.then(function(value) {
			
			self.commenresponse=value.data;
			
			
		}, function(reason) {
			
			self.commenresponse=reason.data;
			
		})
		

		
		
	};
	
	
	
}})();

