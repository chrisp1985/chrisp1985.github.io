package Methods;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PageObjects.AbstractSharedObjects;
import PageObjects.ExamplesPages;
import PageObjects.HomeObjects;
import PageObjects.ToolsObjects;
import io.appium.java_client.android.AndroidDriver;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by chrisp on 01/08/2016.
 * Automation Methods for the Android tests.
 */
public class AutomationMethods {

    AndroidDriver driver;
    HomeObjects objects;
    ToolsObjects toolsObjects;

    /**
     * The constructor for the methods.
     * @param driver Pass in the Android driver being used in the tests.
     */
    public AutomationMethods(AndroidDriver driver) {
        this.driver = driver;
        objects = new HomeObjects(driver);
        toolsObjects = new ToolsObjects(driver);
    }

    /**
     * Take a screenshot of the device.
     * @param fileName The filename of the saved screenshot.
     */
    public void takeAScreenShot(String fileName) {
        // Adding a screenshot to see what's going on.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils
                    .copyFile(scrFile, new File(System.getProperty("user.dir") + "\\build\\tmp\\" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check that the drawer element is NOT open.
     * @return Boolean check to see if the toolbar Monkey is displayed (therefore the drawer is not open).
     */
    public boolean checkThatDrawerIsNotOpen() {

        return objects.monkeyToolBar().isDisplayed();
    }

    /**
     * Check that the drawer element is open.
     * @return Boolean check to see if the drawer element is visible to the user.
     */
    public boolean checkThatDrawerIsOpen() {

        return objects.boundsOfScreen().isDisplayed();
    }

    /**
     * Click the Home monkey.
     */
    public void clickMyMonkey() {

        objects.monkeyToolBar().click();
    }

    /**
     * Click on the drawer button (to open the drawer)
     */
    public void clickTheDrawerButton() {
        // Note: Added to a method so if functionality changes and this becomes a double-
        // click, only one method needs to be changed rather than the reference within each
        // test case.
        new HomeObjects(driver).menuButton().click();
    }

    /**
     * Open the drawer if it's not open.
     */
    public void openTheDrawer() {
        if (checkThatDrawerIsNotOpen()) {
            clickTheDrawerButton();
        }
    }

    /**
     * Close the draw via a swipe.
     */
    public void closeTheDrawer() {
        // Get the bounds of the driver.
        int swipeBoundX = (int) (objects.boundsOfScreen().getSize().width * 0.9);
        int swipeBoundEndX = (int) (objects.boundsOfScreen().getSize().width * 0.2);
        int swipeBoundY = (int) (objects.boundsOfScreen().getSize().height * 0.5);
        try {
            driver.swipe(swipeBoundX, swipeBoundY, swipeBoundEndX, swipeBoundY, 200);
        } catch (Exception e) {
            // Do nothing.
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(objects.monkeyToolBar()));
    }

    /**
     * Go to a specific screen within the app via the drawer menu.
     * @param screen The desired screen (as per the item name in the drawer list).
     */
    public void navigateToScreen(String screen) {
        openTheDrawer();
        for (WebElement item : new HomeObjects(driver).menuItems()) {
            // Click the item
            String itemName = item.findElement(By.className("android.widget.CheckedTextView")).getText();
            if (itemName.equals(screen)) {
                item.click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get all of the tab names available in the horizontal scrollview tabhost.
     * @param objsPage The objects page that implements ExamplesPages.
     * @return A list of the tab names available in the tabhost.
     */
    public List<String> getTabNamesInScrollView(ExamplesPages objsPage) {

        // Set prevLastVisible to a blank string, and setup the foundItems list.
        String prevLastVisible = "";
        List<String> foundItems = new ArrayList<>();

        // Get the lastVisible tab, and check it doesn't match the previous last visible tab.
        List<WebElement> lastVisible = objsPage.tabItems();
        while (!lastVisible.get(lastVisible.size() - 1).getText().equals(prevLastVisible)) {

            // Set prevLastVisible to the current lastVisible for the next loop.
            prevLastVisible = lastVisible.get(lastVisible.size() - 1).getText();

            // Add the visible tabs to the list that have not already been added.
            for (WebElement foundEle : objsPage.tabItems()) {
                if (!foundItems.contains(foundEle.getText())) {
                    foundItems.add(foundEle.getText());
                }
            }

            // Find the bounds of the tabhost, then drag from 70% of the way along, back to 30%.
            int lastVisX = (int) (objsPage.genericItemsMenu().getLocation().getX() + (objsPage.genericItemsMenu().getSize().width * 0.7));
            int y_coord = (int) (objsPage.genericItemsMenu().getLocation().getY() + (objsPage.genericItemsMenu().getSize().height * 0.5));
            int firstVisX = (int) (objsPage.genericItemsMenu().getLocation().getX() + (objsPage.genericItemsMenu().getSize().width * 0.3));

            // Drag the list, to see what tabs are available.
            driver.swipe(lastVisX, y_coord, firstVisX, y_coord, 500);
            lastVisible = objsPage.tabItems();
            lastVisible.get(lastVisible.size() - 1).getText();
        }
        return foundItems;
    }

    /**
     * Allows a user to click a scroll view item in the tab host.
     * @param objsPage The objects page that implements ExamplesPages.
     * @param itemName The item (tabname) required.
     * @return A boolean for whether it's found or not (if it isn't, it won't be clicked...).
     */
    public boolean clickScrollViewItem(ExamplesPages objsPage, String itemName) {
        boolean itemFound = false;
        String prevLastVisible = "";

        // Get the lastVisible tab, and check it doesn't match the previous last visible tab.
        List<WebElement> lastVisible = objsPage.tabItems();
        while (!lastVisible.get(lastVisible.size() - 1).getText().equals(prevLastVisible) && !itemFound) {

            // Set prevLastVisible to the current lastVisible for the next loop.
            prevLastVisible = lastVisible.get(lastVisible.size() - 1).getText();

            // Add the visible tabs to the list that have not already been added.
            for (WebElement foundEle : objsPage.tabItems()) {
                if (foundEle.getText().equals(itemName)) {
                    foundEle.click();
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                // Find the bounds of the tabhost, then drag from 70% of the way along, back to 30%.
                int lastVisX = (int) (objsPage.genericItemsMenu().getLocation().getX() + (objsPage.genericItemsMenu().getSize().width * 0.7));
                int lastVisY = (int) (objsPage.genericItemsMenu().getLocation().getY() + (objsPage.genericItemsMenu().getSize().height * 0.5));
                int firstVisX = (int) (objsPage.genericItemsMenu().getLocation().getX() + (objsPage.genericItemsMenu().getSize().width * 0.3));
                int firstVisY = (int) (objsPage.genericItemsMenu().getLocation().getY() + (objsPage.genericItemsMenu().getSize().height * 0.5));

                // Drag the list, to see what tabs are available.
                driver.swipe(lastVisX, lastVisY, firstVisX, firstVisY, 500);
                lastVisible = objsPage.tabItems();
                lastVisible.get(lastVisible.size() - 1).getText();
            }
        }
        return itemFound;
    }

    /**
     * Click the WebView button in one of the examples pages.
     * @param objsPage The objects page that implements ExamplesPages.
     */
    public void clickWebViewButton(ExamplesPages objsPage)
    {
        objsPage.webViewButton().click();
    }

}
