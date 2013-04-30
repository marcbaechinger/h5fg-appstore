(function () {
    'use strict';

    angular.module('appstore.directives', []).
      directive('appVersion', ['version', function(version) {
        return function(scope, elm, attrs) {
          elm.text(version);
        };
      }]);    
}());
