package tests;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import PageObjects.ToolsObjects;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chrisp on 15/08/2016.
 * Test Suite for the Tools screen.
 */
@Ignore 
public class ToolsTests extends AbstractTestSetup{

    public static final List<String> expectedTabs = Arrays.asList(
            "Jasmine",
            "Protractor",
            "Selenium",
            "UIAutomation",
            "API",
            "JMeter",
            "Other Tools");

    private static ToolsObjects toolsObjects;

    /**
     * Constructor for the Tools test suite.
     */
    public ToolsTests() {
        toolsObjects = new ToolsObjects(driver);
    }

    @Test
    public void displaysJasmineOnOpen() {
        // Go to the Tools screen.
        methods.navigateToScreen("Tools");

        // Check Jasmine is the first page displayed.
        assertEquals(toolsObjects.toolsDisplayedHeading().getText(),"Jasmine");
    }

    @Test
    public void verifyCorrectNumberOfTabsAndSelected() {
        // Go to the Tools screen.
        methods.navigateToScreen("Tools");

        // Check that the tab names are as expected.
        assertEquals(new HashSet(expectedTabs),new HashSet(methods.getTabNamesInScrollView(toolsObjects)));
    }

    @Test
    public void displaysCorrectTextForEachTab() {
        // Go to the Tools screen.
        methods.navigateToScreen("Tools");

        // Check that each tab can be displayed.
        for(String tabName: expectedTabs) {
            methods.clickScrollViewItem(toolsObjects,tabName);
        }
    }

    @Ignore
    public void checkForToastOnOpen() {
        // TODO: Toast checking not available in Appium.
    }

    @Test
    public void switchToWebViewShowsWebPage() {
        // Go to the tools screen.
        methods.navigateToScreen("Tools");

        // Click the Webview button
        methods.clickWebViewButton(toolsObjects);

        // Check for Progress Bar.
        assertTrue(toolsObjects.progressBar().isDisplayed());

        // Check that the website is displayed.
        assertTrue(toolsObjects.toolsWebPage().isDisplayed());
    }
}
