(function  (){
var homeapp=angular.module("homeapp");
homeapp.controller("controller", function($scope,service) {
this.tokenReceived;
var self=this;
this.showimage=true;

this.accountlist;
this.hideaddacc=true;

this.getData=function(){
var promise=service.getDataService(this.tokenReceived);

promise.then(function(response) {
console.log(response.data);	
},

function(errorresponse) {
//redirect to login page
document.getElementById('lbutton').click();




});	


};
//function 1 end
this.getAccounts=function(){
var promise=service.getUserAccounts(this.tokenReceived);	
promise.then(function(response) {
	//self.AccountList=response.data;
	console.log(response.data);
	$scope.c.accountlist=response.data;
	
	
}, function(errorresponse) {
console.log(errorresponse.data);	
});
//all callbacks over

}
//function 2 exit
this.AccountShow;
this.showAccDetails=function(index){
this.AccountShow=$scope.c.accountlist[index];	
console.log(this.AccountShow);
this.showimage=false;
this.hideaddacc=true;	

}
//function 3

this.getAccpvds=function(){
this.listpvds=service.getAccPvds(this.tokenReceived);	
this.hideaddacc=false;	
this.showimage=true;
cocnsole.log("here...>>>>>>>");
}

//function 4 goes heer
this.acclistpsp=false;
this.getAccountsofBanks=function(index){	
this.acclistpsp=true;

}



})
})();