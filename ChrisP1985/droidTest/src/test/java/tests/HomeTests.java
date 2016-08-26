package tests;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;

import PageObjects.HomeObjects;
import PageObjects.OtherToolsObjects;
import PageObjects.ThisAppObjects;
import PageObjects.ToolsObjects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by chrisp on 01/08/2016.
 * Test suite for the Home Page.
 */
 @Ignore
public class HomeTests extends AbstractTestSetup {

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

        try {
            // Wait for the home title to be displayed
            assertTrue(homeObjects.homeTitle().isDisplayed());

            // Make sure the drawer isn't open to begin with.
            assertTrue(methods.checkThatDrawerIsNotOpen());

            // Click the menu button.
            homeObjects.menuButton().click();

            // Check that the drawer is opened.
            assertTrue(methods.checkThatDrawerIsOpen());
        }
        finally {
            methods.closeTheDrawer();
        }
    }

    @Test
    public void contentOfTheDrawerIsCorrect() {

        try {
            // Open the drawer.
            methods.openTheDrawer();

            // Iterate over items, check that each expected item is in the list.
            assertEquals(new HashSet(expectedNavLinks), new HashSet(homeObjects.menuItemsStrings()));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            methods.closeTheDrawer();
        }
    }

    @Test
    public void linksToAllFragmentsAreCorrect() {

        // Open the drawer.
        methods.openTheDrawer();

        // Check that each a href is correct.
        for(WebElement item: homeObjects.menuItems()) {

            // Click the item
            String itemName = item.findElement(By.className("android.widget.CheckedTextView")).getText();

            // Check it goes to the correct page.
            switch (itemName) {
                case "Tools":
                    item.click();
                    // Check for the image, the heading and the text.
                    assertTrue(new ToolsObjects(driver).pageImage().isDisplayed());
                    assertTrue(new ToolsObjects(driver).pageDescription().isDisplayed());
                    assertTrue(new ToolsObjects(driver).pageHeading().isDisplayed());

                    break;
                case "Other Tools":
                    item.click();
                    // Check for the image, the heading and the text.
                    assertTrue(new OtherToolsObjects(driver).pageImage().isDisplayed());
                    assertTrue(new OtherToolsObjects(driver).pageDescription().isDisplayed());
                    assertTrue(new OtherToolsObjects(driver).pageHeading().isDisplayed());

                    break;
                case "This App":
                    item.click();
                    // Check for the image, the heading and the text.
                    assertTrue(new ThisAppObjects(driver).pageImage().isDisplayed());
                    assertTrue(new ThisAppObjects(driver).thisAppDescHeading().isDisplayed());
                    assertTrue(new ThisAppObjects(driver).pageHeading().isDisplayed());

                    break;
                case "Home":
                    item.click();
                    // Check for the image, the heading and the text.
                    assertTrue(new HomeObjects(driver).carousel().isDisplayed());
                    assertTrue(new HomeObjects(driver).homeTitle().isDisplayed());

                    break;
                case "My Website":
                    // Do nothing for now.
            }

            // Click the monkey to get back to the homepage and then open the drawer.
            methods.clickMyMonkey();
            methods.openTheDrawer();
        }

        // Close the drawer to end the test.
        methods.closeTheDrawer();
    }
}
