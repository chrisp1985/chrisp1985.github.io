(function() {
    var app = angular.module("uiViewModule",['ui.router']);

    app.config(function($stateProvider, $urlRouterProvider){

        // For any unmatched url, send to /home
        $urlRouterProvider.otherwise("/home")

        $stateProvider
            .state('home', {
                url: "/home",
                templateUrl: "home2.html"
            })
            .state('tools', {
                url: "/tools",
                templateUrl: "tools2.html"
            })
            .state('this_site', {
                url: "/this_site",
                templateUrl: "this_site2.html"
            })
    });
})();