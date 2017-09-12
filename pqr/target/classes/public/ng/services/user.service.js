app.factory('UserDataOp', ['$http', function($http) {

	var UserDataOp = {};

	UserDataOp.getUsers = function(){
		return $http({
			method: 'GET',
			url: 'Users'
		})
	}
	
	UserDataOp.addUser = function(user){
		return $http({
			method: 'POST',
			 url: 'User/addUser',
			 dataType: 'json',
			 data: user,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	UserDataOp.updateUser = function(user){
		return $http({
			method: 'POST',
			 url: 'User/updateUser',
			 dataType: 'json',
			 data: user,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	return UserDataOp;
}]);