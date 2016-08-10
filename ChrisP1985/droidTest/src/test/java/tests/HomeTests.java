package tests;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import Methods.AutomationMethods;
import Methods.CreateDriver;
import PageObjects.HomeObjects;
import io.appium.java_client.android.AndroidDriver;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by chrisp on 01/08/2016.
 *
 *
 */
@Ignore
public class HomeTests {
    private static AndroidDriver driver;
    private HomeObjects homeObjects;
    private AutomationMethods methods;

	private static List<String> expectedNavLinks = Arrays.asList(
            "Home",
            "Tools",
            "Other Tools",
            "This App");

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

    @Test
    public void clickTheMenuButtonOpensTheDrawer() {
        // Wait for the home title to be displayed
        assertTrue(homeObjects.homeTitle().isDisplayed());

        // Make sure the drawer isn't open to begin with.
        assertFalse(methods.checkIfDrawerIsOpen());

        // Click the menu button.
        homeObjects.menuButton().click();

        // Check that the drawer is opened.
        assertTrue(methods.checkIfDrawerIsOpen());
    }

    @Ignore
    public void contentOfTheDrawerIsCorrect() {
		// Open the drawer.
		
		// Iterate over items, check that each expected item is in the list.
    }

    @Ignore
    public void linksToAllFragmentsAreCorrect() {
		// Open the drawer.
		
		// Check that each a href is correct.
		
    }
}
