app.controller('ProjectsController', function($rootScope, $scope, $state,ProjectDataOp){
	
	$scope.search ="";
	$scope.project ={};
	
	$scope.projectList =[];
	
	ProjectDataOp.getProjects()
		.then(function(response){
			$scope.projectList = response.data;
		}).catch(function(error) {
			console.log(error);
		});
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchProject = function(){}
	
	$scope.addProject = function(){
		console.log("add project");
	}
	
	$scope.showAddModal = function(project){
		$scope.project = project;
		console.log(project);
	}
	$scope.showEditModal = function(project){
		$scope.project = project;
		console.log(project);
	}
	
}); 