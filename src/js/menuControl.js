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
            description:"Jasmine is a unit testing tool framework that allows developers to verify and validate Javascript components.",
            example1:"This code checks the login method in an authentication module. The login method was a factory that executed a $http POST request, and returned a success or error callback. \nA challenge of testing HTTP requests is that a mock backend server needs to be in place, returning a known result to test against. The angular-supplied $httpBackend allows expectXXX methods to set up the responses for the request made. \nIn this example, it is expected that if the user supplies invalid credentials a 500 error should be returned, while valid credentials would return 200 success. \nOnce the method is executed, the backend must be flushed to allow the request to be made and for the server to execute the expected response. If the backend is not flushed, the test will get to the .success and then not go any further. The spy at the end of the test verifies that the callback is successfully executed.",
            example2:"This code checks that when a file is uploaded, it is seen as ‘added’ if it contains a .txt extension. The ‘flow’ module an angular extension that allows for a button click or drag and drop of a file to upload to a server, so the test has to first set up the mock file to upload. \nOne of the main difficulties in this test involves mocking a window so that when the window opens a new URL, you don’t get a ‘Some of your tests did a full page reload!’ error. \nMocking is a large part of the setup for Jasmine tests. The tests can often take minutes to write, with the environment setup taking the bulk of the time.",
            example3:""
        },
        {
            name:"Selenium Text",
            description:"Selenium is a framework that allows a user to interact with elements in the DOM to test a website.",
            example1:"This pretty simple test logs in to the application as part of the @BeforeClass, and then clicks on each tab in the page and verifies their content. \nOnce the test is complete, the content is cleared so each test begins with the same data present, and at the end of the suite the driver is closed. The @Rule allows for screenshots to be taken on a failing test by overriding the failed method in the abstract TestWatcher jUnit class.",
            example2:"This is the login method that Example 1 uses in its @BeforeClass. This method shows how to a) resize a window if needed and b) bypasses internet explorers certification requirement. A Javascript executor is used to do this. \nThe Javascript executor method can also extremely useful for scrolling to elements on the page that aren’t visible, and has been used frequently for unhiding hidden browse to file buttons."
        },
        {
            name:"UI Automation Text",
            description:"UI Automation is an automation framework developed by Microsoft to automate actions within a desktop application.",
            example1:""
        },
        {
            name:"API Text",
            description:"The REST API uses the URI of HTTP Requests to GET and DELETE resources, whilst using the body of the request to POST or PUT resources.",
            mocha:"This is a mocha example.",
            restassured:"This is a RestAssured example.",
            restsharp:"This is a RestSharp example."
        },
        {
            name:"JMeter",
            description:"JMeter is a performance testing tool that allows for monitoring of throughputs and response times."
        }
    ];
})();