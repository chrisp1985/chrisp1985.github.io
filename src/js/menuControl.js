(function() {
    var app = angular.module("myModule",['ui.router']);

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
                templateUrl: "tools.html"
            })
            .state('this_site', {
                url: "/this_site",
                templateUrl: "this_site.html"
            })
    })

    .controller("myCtrl", function() {
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
            languages:"Javascript",
            example1:"This code checks the login method in an authentication module. The login method was a factory that executed a $http POST request, and returned a success or error callback. \nA challenge of testing HTTP requests is that a mock backend server needs to be in place, returning a known result to test against. The angular-supplied $httpBackend allows expectXXX methods to set up the responses for the request made. \nIn this example, it is expected that if the user supplies invalid credentials a 500 error should be returned, while valid credentials would return 200 success. \nOnce the method is executed, the backend must be flushed to allow the request to be made and for the server to execute the expected response. If the backend is not flushed, the test will get to the .success and then not go any further. The spy at the end of the test verifies that the callback is successfully executed.",
            example2:"This code checks that when a file is uploaded, it is seen as ‘added’ if it contains a .txt extension. The ‘flow’ module an angular extension that allows for a button click or drag and drop of a file to upload to a server, so the test has to first set up the mock file to upload. \nOne of the main difficulties in this test involves mocking a window so that when the window opens a new URL, you don’t get a ‘Some of your tests did a full page reload!’ error. \nMocking is a large part of the setup for Jasmine tests. The tests can often take minutes to write, with the environment setup taking the bulk of the time.",
            example3:""
        },
        {
            name:"Selenium Text",
            description:"Selenium is a framework that allows a user to interact with elements in the DOM to test a website.",
            languages:"Java",
            example1:"This pretty simple test logs in to the application as part of the @BeforeClass, and then clicks on each tab in the page and verifies their content. \nOnce the test is complete, the content is cleared so each test begins with the same data present, and at the end of the suite the driver is closed. The @Rule allows for screenshots to be taken on a failing test by overriding the failed method in the abstract TestWatcher jUnit class.",
            example2:"This is the login method that Example 1 uses in its @BeforeClass. This method shows how to a) resize a window if needed and b) bypasses internet explorers certification requirement. A Javascript executor is used to do this. \nThe Javascript executor method can also be extremely useful for scrolling to elements on the page that aren’t visible, and has been used frequently for unhiding hidden browse to file buttons."
        },
        {
            name:"UI Automation Text",
            description:"UI Automation is an automation framework developed by Microsoft to automate actions within a desktop application.",
            languages:"C#",
            example1:"This example attempts to mimic Selenium’s waitUntil WebDriverWait method. As each element is returned in its own method within the PageObjects class, the function needs to be able to determine the object to use by its method name. In this case, reflection is used to invoke the method by the element name passed in. The function has to behave in this way because page object is only returned if a scan of the available objects returns a result. If the object was passed in, it would always have the same status (not available) throughout the process because it is an object created from a class and not a dynamic element. If the timer expires, a failure assertion is thrown so the test fails. These tests are executed using nUnit.",
            example2:"This method allows for a service to be stopped or started by its service name. It iterates over each of the services listed and then, if the service name is equal to the one being searched for, stops or starts the service based on the bool stop parameter. The wait for the service to be .Running or .Stopped makes sure that the next part of the test isn’t attempted before the shutdown or startup is finished.",
            example3:"This is the test that uses the start/stop service method. The test starts the application, and then disconnects the service before attempting to execute the run command. Once it shows the error message, the test is seen as passed and then starts the service again ready for the next test. The reason the test is wrapped in a try/finally is to make sure the service is restarted at the end of the test regardless of the result. If the start service wasn’t held in the finally and the test failed, it wouldn’t be executed."
        },
        {
            name:"API Text",
            description:"The REST API uses the URI of HTTP Requests to GET and DELETE resources, whilst using the body of the request to POST or PUT resources.",
            languages:"Javascript, Java, C#",
            mocha:"Mocha, like Jasmine, is based on Node and uses the same describe/it syntax. This example sends a PUT request to the server to add a user, with the data held in the body of the message. The test uses ‘should’ to assess the result of the test, reading the status code and body of the response.",
            restassured:"These simple tests put and get resources via the API. The PUT is necessary for the GET to be able to retrieve the resource. The tests are run using jUnit and follow a BDD syntax (given/when/then) in the putRequest and deleteRequest methods.",
            restsharp:"RestSharp is pretty similar to RestAssured only for C# rather than Java. This method GETs a resource by building up the request, executing it and returning the content of the response for test evaluation."
        },
        {
            name:"JMeter",
            description:"JMeter is a performance testing tool that allows for monitoring of throughputs and response times.",
            languages:"BeanShell",
            jmxexample:"JMeter gives a tester a few performance measuring sticks to apply to their service, be it data throughput or coping with stress and load, or for checking that all requests are met with a response. JMeter stores data as .JMX which is basically a JMeter XML file. Getting information directly from the JMX file is difficult, so the GUI is used to parse the data. In this example, the application is being checked by creating, deleting and copying/pasting the data stored within the service. The tests use standard HTTP GET, DELETE, PUT commands to do this. The reports at the bottom show throughput and response times, and allow for manual checking the times fall within the expected ranges. This can be easily tied into a maven or gradle build via plugins, and is currently used to check general stability of each build created with an automated report delivered on completion."
        },
        {
            name:"Other Tools",
            description:"Other tools used include TestComplete, Sikuli and Robot Framework.",
            languages:"C#-Script, Python",
            testcomplete:"TestComplete is a tool from SmartBear for automation of mobile, web and desktop apps. Most of the code written with TestComplete was in C#-script, which is a hybrid of Javascript and C# without really being similar to either of them. The framework itself is very easy to get into, as a lot of the heavy lifting is done for you. Whereas with other frameworks you may need to devise your own application object model, TestComplete does this for you. The easiest way to store objects for a test quickly is to record/playback a test case, and then edit the test using the objects that are stored. Tests are easy to create without using record/playback, but require an Object Spy to manually map everything being used before a test can be executed.",
            sikuli:"Sikuli is a framework that uses image recognition. Relying on image recognition only in test cases has some serious limitations, but combining it with Selenium meant that DOM objects could be manipulated but the actual look and feel of the UI could be verified at the same time. As the tool uses image recognition, a lot of images need to be stored which can bloat a project’s size. The language used in Sikuli is python.",
            robotframework:"Robot Framework is a very high-level test runner. Tests can be written by piecing together keywords, with the libraries those keywords call sitting underneath. It feels like a cumbersome tool, but was very useful for combing Sikuli and Selenium into one suite."
        },
        {
            name:"Build Environment",
            description:"Build environment tools in a testing context.",
            languages:"XML, Groovy",
            maven:"Maven uses an XML syntax which is very verbose and not particularly easy on the eye. As all dependency injections and tasks require open/closing tags (as all XML documents do), the actual content of the build environment is pretty minimal compared to the framework that sits around it.",
            gradle:"Gradle uses Groovy, which is a lot easier to view and gives as much flexibility as Maven without the need for tags everywhere. Applying dependencies in Gradle can be performed by using the compile command. The Java plugin allows for the test{ } section to be used, which means the user can access tests by gradlew <module>:test. Custom tasks can also be accessed this way. If I wanted to execute the copyMyApplicationLogs task, I could use gradlew <mymodule>:copyMyApplicationLogs which would only copy logs from one destination to the other. If I chose to run gradlew <mymodule>:installMyApplication, it would first execute the build task in the ‘buildmyapp’ module because of the dependency stated, and then go onto execute this task if the build task was successful.",
            git:"Git can be used to collect or submit data to a private or public repository. The example shows some fairly basic examples, but the notable ones are clone, pull, status, add, commit and push. Clone allows a user to clone a whole repository, for example from GitHub or Bitbucket. If a repository has already been cloned, the ‘git pull’ command collects the latest versions of any updated files between the user’s current working copy and the latest one. Once changes are made (which can be viewed with git status), git add will add all of the data to the staging area. Git commit –m”<Message>” will commit the data to a stored push request. Git push –u <dest> <source> then pushes the changes into the repository for other people to use. All of this website has been changed using Git (it’s on GitHub…). All of these commands are run through the console which in this case is being executed on Ubuntu."
        }
    ];
})();