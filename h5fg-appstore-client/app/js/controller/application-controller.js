(function (global) {
    'use strict';

    function ApplicationController(appstore, adn, $scope) {
        appstore.applicationIndex(function(applications) {
            $scope.applications = applications;
        });
        adn.applicationIndex(function(applications) {
            $scope.resources = applications;
        });
    };

    ApplicationController.$inject = ["appstore", "adn", "$scope"];
    
    global.ApplicationController = ApplicationController;
}(this));
