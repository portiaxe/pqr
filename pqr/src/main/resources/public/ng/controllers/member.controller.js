app.controller('MemberController', function($rootScope, $scope, $state,MemberDataOp){
	
	$scope.search ="";
	$scope.member ={};
	
	$scope.memberList =[];
	
	MemberDataOp.getMembers()
		.then(function(response){
			$scope.memberList = response.data;
		}).catch(function(error) {
			console.log(error);
		});
	
	$scope.searchDB = function(){
		console.log("search");
	}
	
	$scope.searchMember = function(){}
	
	$scope.addMember = function(){
		console.log("add project");
	}
	
	$scope.showAddModal = function(member){
		$scope.member = member;
		console.log(member);
	}
	$scope.showEditModal = function(member){
		$scope.member = member;
		console.log(member);
	}
	
}); 