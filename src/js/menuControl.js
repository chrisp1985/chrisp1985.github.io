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
            tab1:"hello",
            name:"Tools and Frameworks"
        },
        {
            tab2:"helloAgain",
            name:"Languages"
        }
    ];
})()