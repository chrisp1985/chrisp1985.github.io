package Methods;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
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

import PageObjects.HomeObjects;
import PageObjects.ToolsObjects;
import io.appium.java_client.android.AndroidDriver;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by chrisp on 01/08/2016.
 */
public class AutomationMethods {

    AndroidDriver driver;
    HomeObjects objects;
    ToolsObjects toolsObjects;

    public AutomationMethods(AndroidDriver driver) {
        this.driver = driver;
        objects = new HomeObjects(driver);
        toolsObjects = new ToolsObjects(driver);
    }

    public void takeAScreenShot(String fileName)
    {
        // Adding a screenshot to see what's going on.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils
                    .copyFile(scrFile, new File(System.getProperty("user.dir") + "\\build\\tmp\\" + fileName + ".png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean checkIfDrawerIsOpen() {
        String drawerDesc = objects.menuButton().getAttribute("name");
        return drawerDesc.contains("Close");
    }

    public void clickMyMonkey() {
        objects.monkeyToolBar().click();
    }

    public void clickTheDrawerButton() {
        // Note: Added to a method so if functionality changes and this becomes a double-
        // click, only one method needs to be changed rather than the reference within each
        // test case.
        new HomeObjects(driver).menuButton().click();
    }

    public void openTheDrawer() {
        if(!checkIfDrawerIsOpen()) {
            clickTheDrawerButton();
        }
    }

    public void navigateToScreen(String screen) {
        openTheDrawer();
        for(WebElement item: new HomeObjects(driver).menuItems()) {
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

    public List<String> getTabNamesInScrollView() {

        // Set prevLastVisible to a blank string, and setup the foundItems list.
        String prevLastVisible = "";
        List<String> foundItems = new ArrayList<>();

        // Get the lastVisible tab, and check it doesn't match the previous last visible tab.
        WebElement lastVisible = toolsObjects.tabItems().get(toolsObjects.tabItems().size()-1);
        while(!lastVisible.findElement(By.className("android.widget.TextView")).getText().equals(prevLastVisible)) {

            // Set prevLastVisible to the current lastVisible for the next loop.
            prevLastVisible = lastVisible.findElement(By.className("android.widget.TextView")).getText();

            // Add the visible tabs to the list that have not already been added.
            for(WebElement foundEle: toolsObjects.tabItems()) {
                if(!foundItems.contains(foundEle.findElement(By.className("android.widget.TextView")).getText())) {
                    foundItems.add(foundEle.findElement(By.className("android.widget.TextView")).getText());
                }
            }

            // Drag the last visible tab left, the entire width of the view.
            int lastVisX = lastVisible.getLocation().getX();
            int lastVisY = lastVisible.getLocation().getY();
            int firstVisX = toolsObjects.tabItems().get(0).getLocation().getX();
            int firstVisY = toolsObjects.tabItems().get(0).getLocation().getY();

            // Drag the list, to see what tabs are available.
            driver.swipe(lastVisX,lastVisY,firstVisX,firstVisY,500);
            lastVisible = toolsObjects.tabItems().get(toolsObjects.tabItems().size()-1);
        }
        return foundItems;
    }

    public void clickScrollViewItem(String itemName) {
        boolean itemFound = false;
        String prevLastVisible = "";
        WebElement lastVisible = toolsObjects.tabItems().get(toolsObjects.tabItems().size()-1);
        while(!itemFound && !lastVisible.findElement(By.className("android.widget.TextView")).getText().equals(prevLastVisible)) {
            prevLastVisible = lastVisible.findElement(By.className("android.widget.TextView")).getText();

            for(WebElement item: toolsObjects.tabItems()) {
                if(item.findElement(By.className("android.widget.TextView")).getText().equals(itemName)) {
                    item.click();
                    itemFound=true;
                    break;
                }
                else {
                    // Drag the last visible tab left, the entire width of the view.
                    int lastVisX = lastVisible.getLocation().getX();
                    int lastVisY = lastVisible.getLocation().getY();
                    int firstVisX = toolsObjects.tabItems().get(0).getLocation().getX();
                    int firstVisY = toolsObjects.tabItems().get(0).getLocation().getY();

                    // Drag the list, to see what tabs are available.
                    driver.swipe(lastVisX,lastVisY,firstVisX,firstVisY,500);
                    lastVisible = toolsObjects.tabItems().get(toolsObjects.tabItems().size()-1);
                }
            }
        }
    }
}
