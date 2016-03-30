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
            name:"Jasmine Text",
            description:"Jasmine description."
        },
        {
            name:"Selenium Text",
            description:"Selenium description."
        },
        {
            name:"UI Automation Text",
            description:"UI Automation description."
        }
    ];
})();