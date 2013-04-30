'use strict';


angular.module('appstore', ['appstore.filters', 'appstore.services', 'appstore.directives']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/store', {templateUrl: 'partials/store.html', controller: StoreController});
    $routeProvider.when('/adn', {templateUrl: 'partials/adn.html', controller: AdnController});
    $routeProvider.when('/register', {templateUrl: 'partials/register.html', controller: RegistrationController});
    $routeProvider.otherwise({redirectTo: '/store'});
  }]);
