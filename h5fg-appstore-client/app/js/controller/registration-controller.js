(function (global) {
    'use strict';

    function RegistrationController(appstore, adn, $scope) {
        
        $scope.application = {};
        
        $scope.addApplication = function (app) {
            $scope.applications.push(app);
        };

        $scope.register = function () {
            var app = angular.extend({}, $scope.application);
            delete app.appUrl;
            adn.register(app, function (success) {
                alert("created");
                $scope.applications.push(app);
                $scope.application = {};
            });
        };
    };
    RegistrationController.$inject = ["appstore", "adn", "$scope"];
    
    global.RegistrationController = RegistrationController;
}(this));
