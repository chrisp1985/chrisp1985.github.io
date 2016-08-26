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

    app.controller("myOtherCtrl", function() {
        this.tab = 1;

        this.selects = otherTabs;

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
            example2:"This code checks that when a file is uploaded, it is seen as ‘added’ if it contains a .txt extension. The ‘flow’ module is an angular extension that allows for a button click or drag and drop of a file to upload to a server, so the test has to first set up the mock file to upload. \nOne of the main difficulties in this test involves mocking a window so that when the window opens a new URL, you don’t get a ‘Some of your tests did a full page reload!’ error. \nMocking is a large part of the setup for Jasmine tests. The tests can often take minutes to write, with the environment setup taking the bulk of the time.",
            example3:""
        },
        {
            name:"Protractor",
            description:"A Javascript framework allowing developers to use Jasmine syntax for E2E testing.",
            languages:"Javascript",
            example1:"Protractor works by loading a Selenium server instance and executing selenium tests on the browser set in the capabilities of the config file. The code here is basically identical to that of the Selenium example, except written in Javascript. Libraries are used and imported using ‘require’, and assert() has been replaced by the expect() which is also used in Jasmine syntax. For writing both unit and E2E tests together, Protractor offers a lot of syntactical benefits. However, browser.waits are often fairly brittle and even built in expected conditions are susceptible to stale element errors."
        },
        {
            name:"Selenium Text",
            description:"Selenium is a framework that allows a user to interact with elements in the DOM to test a website.",
            languages:"Java, Javascript",
            example1:"This pretty simple test logs in to the application as part of the @BeforeClass, and then clicks on each tab in the page and verifies their content. \nOnce the test is complete, the content is cleared so each test begins with the same data present, and at the end of the suite the driver is closed. The @Rule allows for screenshots to be taken on a failing test by overriding the failed method in the abstract TestWatcher jUnit class.",
            example2:"This is the login method that Example 1 uses in its @BeforeClass. This method shows how to a) resize a window if needed and b) bypasses Internet Explorer's certification requirement. A Javascript executor is used to do this. \nThe Javascript executor method can also be extremely useful for scrolling to elements on the page that aren’t visible, and has been used frequently for unhiding hidden browse-to-file buttons.",
            pythondriver:"This example shows the creation of a webdriver using Python bindings. There are some weird bits, like visibility of an element requiring double parentheses around the locator and some of the syntax is slightly different elsewhere too, but generally if you can use the Java version it’s reasonably easy to get set up with Python. This specific class allows for the driver to be setup, so that when the module is imported and used in a different class, the method is available. But it also contains the ‘if __name__ == \"__main__\":’ statement at the bottom, which means it can be run in isolation (ie doesn’t need anything else to make the method execute). I’m using PyCharm (JetBrains) as an IDE, and when I execute the script it automatically passes the name as __main__, which it wouldn’t do if the module was imported.",
            python1:"This example shows a full example of how a login page might be tested. As in all of the examples from other projects, the test suite is broken out into objects, methods and the tests. The Python bindings differ from Java in that the expected conditions class doesn’t have a urlContains method included, so this has to be manually created. This one basically looks to see if the URL contains the string supplied, and while it doesn’t it waits for a second. If the time meets the wait count supplied by the user, an exception is thrown and the test fails. The unit testing framework is implemented through inheritance, and is the standard unit test tool supplied for Python. The setup and teardown methods are specific to unittest.TestCase and are run at the beginning and end of each test case. The setUpClass and tearDownClass methods can be used to bookend the test suite too."
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
            restsharp:"RestSharp is pretty similar to RestAssured only for C# rather than Java. This method GETs a resource by building up the request, executing it and returning the content of the response for test evaluation.",
            marvel:"The Marvel API is an official REST API developed by Marvel to let developers get information on characters, comics, stories and other things to do with the Marvel Universe. You need to supply a public key, a timestamp and an MD5 hash of your public key, private key and timestamp along with your search queries, which can be created by an online MD5 hasher. The example shows a GET for ‘name=Deadpool’. Execute the call in Poster, Postman, DHC or some other API request tool and then stick this into an online JSON parser and you can see that it gives comics, series, stories, events and URLs to do with Deadpool. The full list of calls can be found at http://developer.marvel.com/docs . Marvel limits REST calls to 1000 calls a day, so as not to over-burden servers so to avoid hitting limits caching is recommended. It’s a powerful database/API combo, but ‘with great power…’ etc etc etc…"
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
    ];

    var otherTabs =
    [
        {
            name:"Jenkins Text",
            description:"The Continuous Integration system that executes tasks according to a schedule or specific trigger.",
            languages:"Bash",
            example1:"Jenkins is a web service used to execute tasks set by a trigger. The service can be deployed by a web server as a WAR, or as an installed Windows service. I have Jenkins installed on Raspbian as a service under /etc/init.d/Jenkins and on a Windows machine as a service. As of Jenkins 2.0, Maven projects require a plugin to run as a Maven-specific project, otherwise all projects are considered Freestyle. The POM or build.gradle location is set in the configuration and trigger options set. In the example, the build is only triggered if there are no builds in the queue. This uses a bash script employing curl to interrogate the Jenkins API, and then greps the queueitem and makes a decision based on that value.  This is quite useful to easing up blockages in the build pipeline so longer projects downstream are triggered with a lower priority to their upstream projects."
        },
        {
            name:"npm",
            description:"NPM, the package manager for the installation of Node modules.",
            languages:"Javascript",
            example1:"Modules can be installed directly from npm using ‘npm install <modulename> --save-dev’. npm has been used to install a lot of node modules, including karma, jasmine and protractor as test frameworks/runners, as well as supplementary functions like require and should."
        },
        {
            name:"Mocking Text",
            description:"Mocking of services, for component testing or to replicate a third party service.",
            languages:"Javascript, Java",
            example1:"The mockserver here allows for an external service on which my application is dependent to be mocked, so that any requests my application makes can be responded to correctly. For example, if my application was to send a GET request to /path/to/my/rest/services, I could expect a response containing my service data which would allow me to carry on testing my application. Without the mock, I would only be able to test up until the point that a request is made. Mockserver is a netty-based service, and can be installed from mavencentral using a compile 'org.mock-server:mockserver-netty:3.10.4' in the build.gradle file for the test suite.",
            example2:"These examples use Angular’s HTTPBackend to mock service responses for Jasmine tests. The first example checks the data returned matches what is expected, while the second example checks that an action occurs as a result of an error callback in the request."
        },
        {
            name:"Linux Text",
            description:"Linux - including Raspbian, Debian, Ubuntu, Mint and SLES.",
            languages:"Shell",
            ssh:"This example shows login and file permission editing through SSH. In this case, the SSH application is used but programs like PuTTY do the same thing. Files can be transferred across to a remote Linux machine using an FTP application like Filezilla. These methods are particularly useful when setting up a server with no GUI, such as a Raspberry Pi. This website has been maintained using Ubuntu 15.10, and sits on a partitioned laptop with Mint 17.3. I’ve also used SUSE Linux Enterprise Server in a previous role.",
            raspbian:"This is Raspbian Jessie, based on Debian. The image here uses VNC Viewer on my phone to remote into the Pi. The Pi zero is very, very slow when running the Jenkins UI, but responds well to general text-based SSH-type commands. And it only costs £4. My Pi Zero initially needed a UI to set up the connected Wifi dongle, but once this was done I was able to install applications through SSH and view the UI through VNC Viewer.",
            aptget:"Apt-get is a really easy way to install programs on linux. Some apps may need you to install via a .deb or .rpm file, or by unpacking a tar.gz, but apt-get allows for a user with admin permission to install programs through ‘sudo apt-get install <program>’. Sudo is needed as root permissions are needed to install software (similar to Admin privileges on Windows)."
        },
        {
            name:"Build Environment",
            description:"Build environment tools in a testing context.",
            languages:"XML, Groovy",
            maven:"Maven uses an XML syntax which is very verbose and not particularly easy on the eye. As all dependency injections and tasks require open/closing tags (as all XML documents do), the actual content of the build environment is pretty minimal compared to the framework that sits around it.",
            gradle:"Gradle uses Groovy, which is a lot easier to view and gives as much flexibility as Maven without the need for tags everywhere. Applying dependencies in Gradle can be performed by using the compile command. The Java plugin allows for the test{ } section to be used, which means the user can access tests by gradlew <module>:test. Custom tasks can also be accessed this way. If I wanted to execute the copyMyApplicationLogs task, I could use gradlew <mymodule>:copyMyApplicationLogs which would only copy logs from one destination to the other. If I chose to run gradlew <mymodule>:installMyApplication, it would first execute the build task in the ‘buildmyapp’ module because of the dependency stated, and then go onto execute this task if the build task was successful.",
            git:"Git can be used to collect or submit data to a private or public repository. The example shows some fairly basic examples, but the notable ones are clone, pull, status, add, commit and push. Clone allows a user to clone a whole repository, for example from GitHub or Bitbucket. If a repository has already been cloned, the ‘git pull’ command collects the latest versions of any updated files between the user’s current working copy and the latest one. Once changes are made (which can be viewed with git status), git add will add all of the data to the staging area. Git commit –m”<Message>” will commit the data to a stored push request. Git push –u <dest> <source> then pushes the changes into the repository for other people to use. All of the website has been changed using Git (it’s on GitHub…). All of these commands are run through the console which in this case is being executed on Ubuntu."
        },
    ];
})();