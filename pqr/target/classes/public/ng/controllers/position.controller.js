app.controller('PositionController', function($rootScope, $scope, $state,PositionDataOp){
	
	$scope.search ="";
	$scope.project ={};
	
	$scope.postionList =[];
	
	PositionDataOp.getPositions()
		.then(function(response){
			$scope.positionList = response.data;
			console.log(response);
		}).catch(function(error) {
			console.log(error);
		});
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchPosition = function(){}
	
	$scope.addPosition = function(){
		console.log("add project");
	}
	
	$scope.showAddModal = function(position){
		$scope.position = position;
		console.log(position);
	}
	$scope.showEditModal = function(position){
		$scope.position = position;
		console.log(position);
	}
	
}); 