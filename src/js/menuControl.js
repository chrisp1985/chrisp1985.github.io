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
	
    app.controller("androidCtrl", function() {
        this.tab = 1;

        this.selects = androidTabs;

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
        {
            name:"Test Reporting",
            description:"Automating test reporting for a project.",
            languages:"Java, Groovy",
            docx4j:"Docx4J is a plugin that can be pulled from MavenCentral that allows for text replacement within a Word document. The approach I took was to create a template Word report document that contained text placeholders, then generate useful information and replace the placeholder text with the real bits. This allows me to keep the formatting of the document in a presentable style whilst presenting real information in the content. Placeholders take the form of ‘${ExampleText}’ where ‘ExampleText’ is the string to replace. Within the Java code, you can then use the variableReplace method and pass in a hashmap of the strings you want to replace with their replacement.",
            jira:"A lot of useful statistics to put into a test report can be gathered from Jira, and its REST API provides an easy way to automate the report generation. Using basic authentication, a user can submit a query and parse the JSON response to find outstanding issue counts, resolved counts, issue descriptions, reporter names etc. In the example, I use RestAssured to send a request with basic authentication to get the resolved issue count, then parse it using a JSONObject plugin translator and get the ‘total’. This can then be added to the report.",
            results:"Each component is tested automatically with the results captured by Gradle. This means that I can define a zipping task, then just put a finalizedBy on the test function within the component to zip up the results. I can then publish to a repository and link to that results location in the document. The groupId and artifactId will always be the same for every release, with only the version changing. This means a string can be formed of a known URL with only the version parts needing to be substituted in each run."
        },		
    ];
	
	var androidTabs =
	[
		{
			name:"Background",
			description:"Why I did this.",
			background1:"Originally, this was planned as an activity to make use of my Raspberry Pi 3: deploy TeamCity (which I’d not used before) and build an Android application. The main issue with the Raspberry Pi is that it uses an ARM chipset, which cannot compile Android SDK binaries and so couldn’t build the artefacts. This meant moving to an AMD/Intel processor to build the software successfully. Using an old PC found in my parents’ loft and adding a couple of extra gigs of RAM, I flattened the machine, installed Debian, MySQL and TeamCity and can now pick up commits to GitHub and automatically build the resulting APK. The build server can be found at http://chrisp1985.ddns.net:8111 . This link isn't always active, because the fan is noisy and uses a lot of energy so I often turn it off.",
			background2:"Android Studio is based off Intelli J so was immediately familiar, but having to edit XML as well as some not-fantastically-well-documented Java made the process a bit tricky. For instance, using a custom typeface isn’t as easy as selecting the text and choosing the font in the visual editor, you have to set the type on creation of the fragment in the Java code. And working out that I needed to open a fragment from the drawer, and then finding out how to do that, wasn’t easy. The intention of this was to create an application that I could test against with Appium, but as Appium requires a) a VTX enabled CPU (which my old PC doesn’t have) or b) a connected Android device (which I don’t have spare), the Appium tests are currently ignored for builds. My focus currently is on creating a relatively solid app, so that any tests I create can check a consistent build rather than one that is liable to drastically change."
		},
		{
			name:"Setup",
			description:"How everything was setup for development and test purposes.",			
			background1:"The OS being used to host the system is Debian Jessie 8. The reasons for using Linux as opposed to Windows are for a) licensing and b) learning. I’ve used Raspbian on my Pi 3 and Zero, and I’ve got Mint and Ubuntu on my laptop, but I’d never used Debian before and, seeing as it’s known for its reliability for server hosting, seemed an appropriate choice to run TeamCity.\n\nTeamCity runs from the “sudo sh /opt/jetbrains/TeamCity/bin/runAll.sh start” command, and stores data in a MySQL database backend. The database is connected to TeamCity using a MySQL JDBC driver. The TeamCity data is then added to MySQL using the ‘create database teamcity character set UTF8 collate utf8_bin;’ command. TeamCity is run from TomCat, so any changes to the ports can be made in the Catalina conf files.",
			background2: "Finally, the project makes a direct link to GitHub to pick up any commits made to my repository. This is really easy and just involves adding the clone link from GitHub to your build. Once this is done, TeamCity interrogates GitHub and finds the root build.gradle file, then sets up the build using this."
		},		
		{
			name:"Development",
			description:"How the app was developed, issues encountered and their solutions.",						
			background1:"From a functional point of view, Android apps are based off activities and fragments. The activities control things, the fragments are pages that can be loaded within the app. Everything from a UI perspective is XML, which can be automatically created based off of UI designs. In my app, I chose to use a drawer activity from the wizard and build around that, which allows the user to drag a drawer from the left side of the app and navigate to elements inside the app.There are a few elements within the app that have been quite tricky to resolve. As mentioned, setting the typeface to a custom TFF is difficult because the view needs to be inflated before anything can be done. Getting views and understanding where things can be added in the XML and where they must be added as part of an activity is pretty important to getting it all functioning properly. The carousel on the home page is provided via a plugin which can be found on Android Arsenal. The images are faded by lowering the alpha attribute.",
			background2:"The intention of the app was just to initially display real-world things to test against: tabs, views, menus etc. The splash screen, font-awesome icons etc were to make the app look nice but the things to make it look nice were amongst the hardest things to implement. For instance, the accordion view was fairly well defined on the jquery site and easy to implement on a webpage. On an Android app, there seems to be no easy way to make this work effectively. As such, I relented and used a webview. The webview requires connection to the internet so it introduced me to permissions, but also meant I could keep the prism CSS and the structure of the webpage.",
			background3:"Another painful issue was to do with tablets. Most of the development I did was tested on my Galaxy S5 and some on an old Galaxy Young running JellyBean. However, in portrait, my Hudl would stutter and flash for no apparent reason. I couldn't find what the issue was, and nowhere reported any issues with any of the components I used when in portrait on a tablet. In landscape it was fine, in portrait it wasn't. As most of the code would be looked at in landscape anyway, the easy resolution was to lock to landscape if the product exceeded a specific length. This gave the benefit of understanding how to restrict functions for certain platforms, but more importantly 'fixed' my problem!"
		},	
		{
			name:"Test",
			description:"How the app is tested (Spoiler: by Appium), issues and solutions.",									
			background1:"The reason for doing any of this was to use Appium to test, which seems to function in more or less the exact same way as Selenium. Boot up the Appium server (hosted on Node), connect a phone, create an AndroidDriver and then do the rest basically the same as you’d do with Selenium. Xpaths can be deduced using the UIAutomaterView batch file found in the tools directory of the SDK. The tests can be run from jUnit and, as long as there’s a connected phone or emulator available, can be easily executed as part of the build cycle.",
			background2:"Appium behaves in a lot of ways exactly the same as Selenium, but has nowhere near the power. XPath in Selenium is easy, and navigating through the DOM in this way makes sense. The implementation in Appium often feels like it’s shoe-horned into the product, forcing users to navigate through classes rather than elements. The broad coverage of Selenium is also lacking, as you can’t build an xPath to find a specific item. With the drawer example, I wanted to check that the items within the drawer matched the items I was expecting. To do this, I attempted to xpath to the textview items within each menu item via return drawerList().findElements( By.xpath(\"//android.support.v7.widget.LinearLayoutCompat/ android.widget.CheckedTextView\")); However, this didn’t work and instead threw back an exception: \“Cannot use xpath locator strategy from an element. It can only be used from the root element\” which is apparently a known limitation of Appium and hasn’t been fixed since it was found in 2014. To get around this, I instead had to create a list of WebElements (which were the items in the list), and then find the strings for each of those items.",
			background3:"For the structure of the test suite, I chose to create abstract classes for both the tests and the objects. By abstracting the test class, I don’t have to repeat the setup/teardown methods for each suite and can keep all of it in one place for easier maintenance. Similarly with the objects, all of the drawer and toolbar elements are shared across pages so it makes more sense to keep these in one place rather than potentially have to update the same methods/objects in 4 or 5 suites. I added an interface for the example pages to use so that I could use the same named methods across any future example pages, and because I only had to write the methods once, then just implement them on the Page Objects with a right-click > implement methods. Each page uses a page image, description, header and toolbar, so is a good candidate for employing an interface. An interface also allowed me to create one tabhost scroll method and one 'open webview' method. As the objects page implements the interface, the method knows that whatever object is passed in must contain the things it needs to be able to perform properly, so I could create one method and pass in an object that uses the interface. Had I not implemented an interface, I'd have had to have a method for each page, with one using the tools objects and one using the othertools objects.",
			background4:"It's surprising to find that for an app test framework, scrolling through options (a common function) isn't really catered for. The TabHost does not give any indication of total tabs available, only those visible. My original test attempted to get the tabItems size and check that the first tab was selected. However the size of the tabItems was only 3, and not the 7 that I was expecting, because that is how many tabs were visible on the screen. As a result, the test failed. Searching on Google to find the tabhost child count gave no solutions, so I had to work around this. My pseudo-code is as follows:\nAdd the visible tabs to the list.\nDrag the point 70% along the width of the tabhost to the point 30% along the width.\nAdd the visible tabs to the list that have not already been added.\nIf the last visible tab is equal to the previous last visible tab, stop. Otherwise, do the dragging again.\nThis works pretty well but is also quite ugly. It’s also surprising that the tab count isn’t available from the TabHost, seeing as you can get the count from within the application’s code by doing getTabHost().getTabWidget().getTabCount()."
		}
	];
})();