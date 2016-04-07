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
            restassured:"These simple tests put and get resources via the API. The PUT is necessary for the GET to be able to retrieve the resource. The tests are run using jUnit and follow a BDD syntax (given/when/then) in the putRequest and deleteRequest methods.",
            restsharp:"RestSharp is pretty similar to RestAssured only for C# rather than Java. This method GETs a resource by building up the request, executing it and returning the content of the response for test evaluation."
        },
        {
            name:"JMeter",
            description:"JMeter is a performance testing tool that allows for monitoring of throughputs and response times."
        },
        {
            name:"Other Tools",
            description:"Other tools used include TestComplete, Sikuli and Robot Framework.",
            testcomplete:"TestComplete is a tool from SmartBear for automation of mobile, web and desktop apps. Most of the code written with TestComplete was in C#-script, which is a hybrid of Javascript and C# without really being similar to either of them. The framework itself is very easy to get into, as a lot of the heavy lifting is done for you. Whereas with other frameworks you may need to devise your own application object model, TestComplete does this for you. The easiest way to store objects for a test quickly is to record/playback a test case, and then edit the test using the objects that are stored. Tests are easy to create without using record/playback, but require an Object Spy to manually map everything being used before a test can be executed.",
            sikuli:"Sikuli is a framework that uses image recognition. Relying on image recognition only in test cases has some serious limitations, but combining it with Selenium meant that DOM objects could be manipulated but the actual look and feel of the UI could be verified at the same time. As the tool uses image recognition, a lot of images need to be stored which can bloat a project’s size. The language used in Sikuli is python.",
            robotframework:"Robot Framework is a very high-level test runner. Tests can be written by piecing together keywords, with the libraries those keywords call sitting underneath. It feels like a cumbersome tool, but was very useful for combing Sikuli and Selenium into one suite."
        }
    ];
})();