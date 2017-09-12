app.controller('UserController', function($rootScope, $scope, $state,UserDataOp){
	
	$scope.search ="";
	$scope.user ={};
	
	$scope.userList =[];
	
	UserDataOp.getUsers()
		.then(function(response){
			$scope.userList = response.data;
		}).catch(function(error) {
			console.log(error);
		});
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchUser = function(){}
	
	$scope.addUser = function(){
		console.log("add project");
	}
	
	$scope.showAddModal = function(user){
		$scope.user = user;
		console.log(user);
	}
	$scope.showEditModal = function(user){
		$scope.user = user;
		console.log(user);
	}
	
}); 