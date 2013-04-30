(function (global) {
    'use strict';

    function StoreController($scope, $http) {
        
        $scope.model = {};
        
        $scope.getJSON = function (url) {
            if ($scope.model.json) {
                delete $scope.model.json;
            } else {
                $http({method: "GET", url: url})
                    .success(function (data) {
                        $scope.model.json = JSON.stringify(data, null, 4);
                    });
            }
        };
    };

    StoreController.$inject = ["$scope", "$http"];
    
    global.StoreController = StoreController;
} (this));
