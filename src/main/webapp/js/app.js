var app = angular.module('app', ['ngMessages']);

app.controller('FlightCtrl', ['$scope','FlightService', function ($scope,FlightService) {

    $scope.submitted = false;

    $scope.findFlightDetails = function() {
        FlightService.findFlightDetails().then( function(data){
            $scope.flights = data;
        });
    }


    $scope.getUsers();

    $scope.resetForm = function () {
        $scope.userForm.$setPristine();
        $scope.user=null;
        $scope.message='';
        $scope.errorMessage='';
        $scope.submitted = false;
    }

}]);

app.service('FlightService',['$http', function ($http) {


    this.findFlightDetails = function findFlightDetails(){
        return $http({
            method: 'GET',
            url: 'flights',
            headers:'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }

}]);