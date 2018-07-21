(function  (){
var homeapp=angular.module("homeapp");
homeapp.controller("controller", function($scope,service) {
this.tokenReceived;
var self=this;
self.serverData;
this.getData=function(){
var promise=service.getDataService(this.tokenReceived);
promise.then(function(response) {
console.log(response.data);	
}, function(errorresponse) {
console.log(errorresponse.data);		
});	


};

console.log($scope);



})
})();