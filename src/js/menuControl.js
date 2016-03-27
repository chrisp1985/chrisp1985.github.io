(function() {
    var app = angular.module("myModule",[]);

    app.controller("myCtrl", function() {
        this.tab = 1;

        this.selects = tabs;

        this.setTab = function(newValue){
          this.tab = newValue;
        };

        this.isSet = function(tabName){
          return this.tab === tabName;
        };
    });

    var tabs = [
        {
            name:"Tools and Frameworks",
            description:"The tools used, like Selenium, UI Automation, TestComplete, Sikuli, RestAssured, "+
            "RestSharp, Mocha, JMeter, Jasmine/Karma and some others."
        },
        {
            name:"Languages",
            description:"The languages I've used, including C#, Java, Javascript and Groovy."
        }
    ];
})();