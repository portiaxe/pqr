app.factory('DepartmentDataOp', ['$http', function($http) {

	var DepartmentDataOp = {};

	DepartmentDataOp.getDepartments = function(){
		return $http({
			method: 'GET',
			url: 'Departments'
		})
	}

	return DepartmentDataOp;
}]);
