package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;

import Methods.AutomationMethods;
import Methods.CreateDriver;
import PageObjects.HomeObjects;
import io.appium.java_client.android.AndroidDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by chrisp on 01/08/2016.
 *
 *
 */
@Ignore
public class DroidTests {

    private static AndroidDriver driver;
    private HomeObjects homeObjects;
    private AutomationMethods methods;

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
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkHomePageIsDisplayedOnAppStart() throws InterruptedException {

        // Wait until the home title is displayed.
        assertTrue(homeObjects.homeTitle().isDisplayed());

        // Check that the icon is displayed.
        assertTrue(homeObjects.carousel().isDisplayed());

        // Check thst the menu is available on the toolbar.
        assertTrue(homeObjects.menuButton().isDisplayed());

        // Take a screenshot to show the home screen.
        methods.takeAScreenShot("homeScreen");
    }

}
