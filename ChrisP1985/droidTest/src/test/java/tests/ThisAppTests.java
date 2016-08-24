package tests;
import org.junit.Ignore;
import org.junit.Test;

import PageObjects.ThisAppObjects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by chrisp on 15/08/2016.
 */

public class ThisAppTests extends AbstractTestSetup {

    @Test
    public void displaysCorrectTextAndImage() {
        methods.navigateToScreen("This App");
        assertTrue(new ThisAppObjects(driver).pageImage().isDisplayed());

        // Check the headings.
        assertEquals(new ThisAppObjects(driver).thisAppDescHeading().getText(),"This Application");
        assertEquals(new ThisAppObjects(driver).pageHeading().getText(),"Why have I done this?");


    }
}
