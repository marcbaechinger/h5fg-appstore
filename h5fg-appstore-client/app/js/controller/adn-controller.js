(function (global) {
    'use strict';

    function AdnController($scope, $http) {
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

    AdnController.$inject = ["$scope", "$http"];
    
    global.AdnController = AdnController;
} (this));
