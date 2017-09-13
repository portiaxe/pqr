app.controller('DeptProjController', function($rootScope, $scope, $state,DeptProjDataOp){
	
	$scope.search ="";
	$scope.dept_proj ={};
	
	$scope.dept_projList =[];
	$scope.targets =[];
	
	DeptProjDataOp.getDeptProj()
		.then(function(response){
			$scope.dept_projList = response.data;
		}).catch(function(error) {
			console.log(error);
		});
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchDeptProj = function(){}
	
	$scope.addDeptProj= function(){
		console.log("add project");
	}
	
	$scope.showTargets = function(targets){
		console.log(targets);
		$scope.targets = targets;
	}
	$scope.showMembers = function(members){
		console.log(members);
	}
	
	$scope.showAddModal = function(dept_proj){
		$scope.dept_proj = dept_proj;
		console.log(dept_proj);
	}
	$scope.showEditModal = function(dept_proj){
		$scope.dept_proj = dept_proj;
		console.log(dept_proj);
	}
	
}); 