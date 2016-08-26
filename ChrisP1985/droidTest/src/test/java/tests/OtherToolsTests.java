package tests;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import PageObjects.OtherToolsObjects;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chrisp on 15/08/2016.
 * Test Suite for the Other Tools screen.
 */
@Ignore
public class OtherToolsTests extends AbstractTestSetup {

    public static final List<String> expectedTabs = Arrays.asList(
            "Linux",
            "NPM",
            "Mocking",
            "Jenkins",
            "Build Environment");

    private OtherToolsObjects otherToolsObjects;

    /**
     * Constructor for the Other Tools test suite.
     */
    public OtherToolsTests() {
        otherToolsObjects = new OtherToolsObjects(driver);
    }

    @Test
    public void displaysLinuxOnOpen() {
        // Go to the Other Tools screen.
        methods.navigateToScreen("Other Tools");

        // Check that the heading is correct.
        assertEquals(otherToolsObjects.otherToolsDisplayedHeading().getText(),"Linux");
    }

    @Test
    public void verifyCorrectNumberOfTabsAndSelected() {
        // Go to the Other Tools screen.
        methods.navigateToScreen("Other Tools");

        // Check the tab names are correct.
        assertEquals(new HashSet(expectedTabs),new HashSet(methods.getTabNamesInScrollView(otherToolsObjects)));
    }

    @Test
    public void displaysCorrectTextForEachTab() {
        // Go to the Other Tools screen.
        methods.navigateToScreen("Other Tools");

        // Check that each tab can be clicked and displayed.
        for(String tabName: expectedTabs) {
            methods.clickScrollViewItem(otherToolsObjects,tabName);
        }
    }

    @Ignore
    public void checkForToastOnOpen() {
        // TODO: Toast checking not available in Appium.
    }

    @Test
    public void switchToWebViewShowsWebPage() {
        // Go to the tools screen.
        methods.navigateToScreen("Other Tools");

        // Click the Webview button
        methods.clickWebViewButton(otherToolsObjects);

        // Check for Progress Bar.
        assertTrue(otherToolsObjects.progressBar().isDisplayed());

        // Check that the website is displayed.
        assertTrue(otherToolsObjects.otherToolsWebPage().isDisplayed());
    }
}
