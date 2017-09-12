app.factory('DeptProjDataOp', ['$http', function($http) {

	var DeptProjDataOp = {};

	DeptProjDataOp.getDeptProj = function(){
		return $http({
			method: 'GET',
			url: 'DepartmentProjects'
		})
	}

	return DeptProjDataOp;
}]);
