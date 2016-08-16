package tests;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import PageObjects.ToolsObjects;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chrisp on 15/08/2016.
 *
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

    public ToolsTests() {
        toolsObjects = new ToolsObjects(driver);

    }

    @Ignore
    public void displaysJasmineOnOpen() {

    }

    @Test
    public void displaysCorrectTextForEachTab() {
        methods.navigateToScreen("Tools");
        methods.clickScrollViewItem("Selenium");
    }

    @Test
    public void verifyCorrectNumberOfTabsAndSelected() {
        methods.navigateToScreen("Tools");
        assertEquals(new HashSet(expectedTabs),new HashSet(methods.getTabNamesInScrollView()));
    }
}
