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

    var tabs =
    [
        {
            name: "Tools and Frameworks",
            description: "The tools used, like Selenium, UI Automation, TestComplete, Sikuli, RestAssured, "+
            "RestSharp, Mocha, JMeter, Jasmine/Karma and some others.",
            jasmine: "This is Jasmine text",
            mocha: "This is Mocha text",
            selenium: "This is Selenium text",
            uiautomation: "This is UIAutomation text",
            testcomplete: "This is TestComplete text",
            sikuli: "This is Sikuli text",
            restassuredsharp: "This is RestAssured text",
            jmeter: "This is JMeter text"
        }
    ];
})();