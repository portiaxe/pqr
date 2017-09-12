app.factory('MemberDataOp', ['$http', function($http) {

	var MemberDataOp = {};

	MemberDataOp.getMembers = function(){
		return $http({
			method: 'GET',
			url: 'Members'
		})
	}
	
	MemberDataOp.addMember = function(member){
		return $http({
			method: 'POST',
			 url: 'Member/addMember',
			 dataType: 'json',
			 data: member,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	MemberDataOp.updateMember = function(member){
		return $http({
			method: 'POST',
			 url: 'Member/updateMember',
			 dataType: 'json',
			 data: position,
			 headers: { 'Content-Type': 'application/json; charset=UTF-8' }
		})
	}

	return MemberDataOp;
}]);