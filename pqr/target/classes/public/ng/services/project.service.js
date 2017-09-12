app.factory('ProjectDataOp', ['$http', function($http) {

	var ProjectDataOp = {};

	ProjectDataOp.getProjects = function(){
		return $http({
			method: 'GET',
			url: 'Projects'
		})
	}
	
	ProjectDataOp.addProject = function(project){
		return $http({
			method: 'POST',
			 url: 'Projects/addProject',
			 dataType: 'json',
			 data: project,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	ProjectDataOp.updateProject = function(project){
		return $http({
			method: 'POST',
			 url: 'Projects/updateProject',
			 dataType: 'json',
			 data: project,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	return ProjectDataOp;
}]);