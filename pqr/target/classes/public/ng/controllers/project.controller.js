app.controller('ProjectsController', function($rootScope, $scope, $state,ProjectDataOp){
	
	$scope.search ="";
	$scope.project ={};
	
	$scope.projectList =[];
	
	loadData();
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchProject = function(){}
	
	$scope.addProject = function(){
		ProjectDataOp
			.addProject($scope.project)
			.then(function(response){
				console.log(response);
				loadData(); //refresh table contents
			})
			.catch(function(error){
				console.log(error);
			});
	}
	
	$scope.showAddModal = function(){
		$scope.project ={};
	}
	$scope.showEditModal = function(project){
		$scope.project = project;
		console.log(project);
	}
	
	function loadData(){
		ProjectDataOp.getProjects()
		.then(function(response){
			$scope.projectList = response.data;
		}).catch(function(error) {
			console.log(error);
		});
	}
}); 