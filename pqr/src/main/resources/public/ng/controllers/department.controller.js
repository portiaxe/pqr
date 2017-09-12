app.controller('DepartmentController', function($rootScope, $scope, $state,DepartmentDataOp){
	
	$scope.search ="";
	$scope.department ={};
	
	$scope.departmentList =[];
	
	DepartmentDataOp.getDepartments()
		.then(function(response){
			$scope.departmentList = response.data;
		}).catch(function(error) {
			console.log(error);
		});
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchDepartment = function(){}
	
	$scope.addDepartment= function(){
		console.log("add project");
	}
	
	$scope.showAddModal = function(department){
		$scope.department = department;
		console.log(department);
	}
	$scope.showEditModal = function(department){
		$scope.department = department;
		console.log(department);
	}
	
}); 