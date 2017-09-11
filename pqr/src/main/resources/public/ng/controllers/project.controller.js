app.controller('ProjectsController', function($rootScope, $scope, $state,ProjectDataOp){
	
	$scope.search ="";
	$scope.projec ={};
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchProject = function(){}
	
	$scope.addProject = function(){
		console.log("add project");
	}
	
	$scope.showAddModal = function(){
		$scope.project = {};
		console.log("open modal");
	}
	
}); 