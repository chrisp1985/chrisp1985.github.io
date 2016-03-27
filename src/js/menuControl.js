(function() {
    angular.module("myModule",[])

    .service("myFirstService",function() {
        this.trial = function() {
            Console.log("hello");
        };
    })
    .controller("myCtrl"[ 'myFirstService',function() {
        this.tab = 1;

        this.setTab = function(newValue){
          this.tab = newValue;
        };

        this.isSet = function(tabName){
          return this.tab === tabName;
        };
    }]);

    var tabs = [
        {
            "tab1":"hello",
            "name":"myTab"
        },
        {
            "tab2":"helloAgain",
            "name":"mySecondTab"
        }
    ];
})()