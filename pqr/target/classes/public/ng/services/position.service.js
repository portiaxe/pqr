app.factory('PositionDataOp', ['$http', function($http) {

	var PositionDataOp = {};

	PositionDataOp.getPositions = function(){
		return $http({
			method: 'GET',
			url: 'Positions'
		})
	}
	
	PositionDataOp.addPosition = function(position){
		return $http({
			method: 'POST',
			 url: 'Positions/addPosition',
			 dataType: 'json',
			 data: position,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	PositionDataOp.updateProject = function(position){
		return $http({
			method: 'POST',
			 url: 'Positions/updatePositions',
			 dataType: 'json',
			 data: position,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	return PositionDataOp;
}]);