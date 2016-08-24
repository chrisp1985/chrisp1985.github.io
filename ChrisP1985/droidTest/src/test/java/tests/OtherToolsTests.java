package tests;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import PageObjects.OtherToolsObjects;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chrisp on 15/08/2016.
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

    public OtherToolsTests() {
        otherToolsObjects = new OtherToolsObjects(driver);
    }

    @Test
    public void displaysLinuxOnOpen() {
        methods.navigateToScreen("Other Tools");
        assertEquals(otherToolsObjects.otherToolsDisplayedHeading().getText(),"Linux");
    }

    @Test
    public void verifyCorrectNumberOfTabsAndSelected() {
        methods.navigateToScreen("Other Tools");
        assertEquals(new HashSet(expectedTabs),new HashSet(methods.getTabNamesInScrollView(otherToolsObjects)));
    }

    @Test
    public void displaysCorrectTextForEachTab() {
        methods.navigateToScreen("Other Tools");
        for(String tabName: expectedTabs) {
            methods.clickScrollViewItem(otherToolsObjects,tabName);
        }
    }
}
