package tests;
import org.junit.Ignore;
import org.junit.Test;

import PageObjects.ThisAppObjects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by chrisp on 15/08/2016.
 * Test Suite for the This App screen.
 */
@Ignore 
public class ThisAppTests extends AbstractTestSetup {

    @Test
    public void displaysCorrectTextAndImage() {
        // Go to the This App screen.
        methods.navigateToScreen("This App");

        // Check the Page image is displayed correctly.
        assertTrue(new ThisAppObjects(driver).pageImage().isDisplayed());

        // Check the headings.
        assertEquals(new ThisAppObjects(driver).thisAppDescHeading().getText(),"This Application");
        assertEquals(new ThisAppObjects(driver).pageHeading().getText(),"Why have I done this?");
    }
}
