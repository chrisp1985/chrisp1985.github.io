package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import Methods.AutomationMethods;
import Methods.CreateDriver;
import PageObjects.HomeObjects;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 15/08/2016.
 */
public abstract class AbstractTestSetup {

    static AndroidDriver driver;
    HomeObjects homeObjects;
    AutomationMethods methods;

    static List<String> expectedNavLinks = Arrays.asList(
            "Home",
            "Tools",
            "Other Tools",
            "This App",
            "My Website");

    @BeforeClass
    public static void setupSuite() throws MalformedURLException {
        // Execute the setup steps.
        driver = CreateDriver.setupDriver();
    }

    @Before
    public void setupTest() throws MalformedURLException {
        // Go to the home page.
        homeObjects = new HomeObjects(driver);
        methods = new AutomationMethods(driver);

        // Click the monkey
        methods.clickMyMonkey();
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void killTheDriver() {
        driver.quit();
    }
}
