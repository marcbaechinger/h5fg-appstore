(function (angular) {
    
    'use strict';
    
    var host = "http://localhost:8080",
        urlBuilder = function (service) {
            var appstoreUrl = host + "/appstore/api/apps";
            if (service === "appstore") {
                return appstoreUrl;
            } else if (service === "adn") {
                return host + "/adn/api/apps";
            }
            return appstoreUrl;
        };
    
    angular.module('appstore.services', [], function($provide) {
        $provide.factory('appstore', ["$http", function($http) {
            return {
                applicationIndex : function (callback) {
                    var url = urlBuilder("appstore");
                    $http({method: "GET", url: url})
                        .success(function (data, status, headers, config) {
                            callback(data)
                        })
                        .error(function (data, status, headers, config) {
                            console.error("error when calling http service for ", url, arguments);
                        });
                }
            };
        }]);
    
        $provide.factory('adn', ["$http", function($http) {
            return {
                register: function (app, callback) {
                    var url = urlBuilder("adn");
                    $http({method: "PUT", url: url, data: app})
                        .success(function (data, status, headers, config) {
                            callback(data)
                        })
                        .error(function (data, status, headers, config) {
                            console.error("error when calling http service: PUT for ", url, arguments);
                        });
                },
                applicationIndex : function (callback) {
                    var url = urlBuilder("adn");
                    $http({method: "GET", url: url})
                        .success(function (data, status, headers, config) {
                            callback(data)
                        })
                        .error(function (data, status, headers, config) {
                            console.error("error when calling http service for ", url, arguments);
                        });
                }
            };
        }]);
    });
}(angular));