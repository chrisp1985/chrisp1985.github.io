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
            example2:"This is the login method that Example 1 uses in its @BeforeClass. This method shows how to a) resize a window if needed and b) bypasses internet explorers certification requirement. A Javascript executor is used to do this. \nThe Javascript executor method can also be extremely useful for scrolling to elements on the page that aren’t visible, and has been used frequently for unhiding hidden browse to file buttons."
        },
        {
            name:"UI Automation Text",
            description:"UI Automation is an automation framework developed by Microsoft to automate actions within a desktop application.",
            example1:"This example attempts to mimic Selenium’s waitUntil WebDriverWait method. As each element is returned in its own method within the PageObjects class, the function needs to be able to determine the object to use by its method name. In this case, reflection is used to invoke the method by the element name passed in. The function has to behave in this way because page object is only returned if a scan of the available objects returns a result. If the object was passed in, it would always have the same status (not available) throughout the process because it is an object created from a class and not a dynamic element. If the timer expires, a failure assertion is thrown so the test fails. These tests are executed using nUnit."
        },
        {
            name:"API Text",
            description:"The REST API uses the URI of HTTP Requests to GET and DELETE resources, whilst using the body of the request to POST or PUT resources.",
            mocha:"Mocha, like Jasmine, is based on Node and uses the same describe/it syntax. This example sends a PUT request to the server to add a user, with the data held in the body of the message. The test uses ‘should’ to assess the result of the test, reading the status code and body of the response.",
            restassured:"These simple tests put and get resources via the API. The put is necessary for the get to be able to retrieve the resource. The tests are run using jUnit and follow a BDD syntax (given/when/then) in the putRequest and deleteRequest methods.",
            restsharp:"RestSharp is pretty similar to RestAssured only for C# rather than Java. This method gets a resource by building up the request, executing it and returning the content of the response for test evaluation."
        },
        {
            name:"JMeter",
            description:"JMeter is a performance testing tool that allows for monitoring of throughputs and response times."
        }
    ];
})();