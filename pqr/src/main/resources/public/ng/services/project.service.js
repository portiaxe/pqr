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
			 url: 'Project/addProject',
			 dataType: 'json',
			 data: book,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	ProjectDataOp.updateProject = function(project){
		return $http({
			method: 'POST',
			 url: 'Project/updateProject',
			 dataType: 'json',
			 data: book,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	return ProjectDataOp;
}]);