package tests;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by chrisp on 01/08/2016.
 *
 *
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
        // Wait for the home title to be displayed
        assertTrue(homeObjects.homeTitle().isDisplayed());

        // Make sure the drawer isn't open to begin with.
        assertFalse(methods.checkIfDrawerIsOpen());

        // Click the menu button.
        homeObjects.menuButton().click();

        // Check that the drawer is opened.
        assertTrue(methods.checkIfDrawerIsOpen());
    }

    @Test
    public void contentOfTheDrawerIsCorrect() {
		// Open the drawer.
		methods.openTheDrawer();

		// Iterate over items, check that each expected item is in the list.
        assertTrue(new HashSet(expectedNavLinks).equals(new HashSet(homeObjects.menuItemsStrings())));
    }

    @Ignore
    public void monkeyReturnsToHome() {

    }

    @Ignore
    public void linksToAllFragmentsAreCorrect() {
		// Open the drawer.
        methods.openTheDrawer();
		
		// Check that each a href is correct.
        for(WebElement item: homeObjects.menuItems()) {
            // Click the item
            String itemName = item.findElement(By.className("android.widget.CheckedTextView")).getText();
            item.click();

            // Check it goes to the correct page.
            switch (itemName) {
                case "Tools":
                    // Check for the image, the heading and the text.

                    break;
                case "Other Tools":
                    // Check for the image, the heading and the text.

                    break;
                case "This App":
                    // Check for the image, the heading and the text.

                    break;
                case "Home":
                    // Check for the image, the heading and the text.

                    break;
            }

            // Click the monkey to get back to the homepage.
            methods.clickMyMonkey();
        }
    }
}
