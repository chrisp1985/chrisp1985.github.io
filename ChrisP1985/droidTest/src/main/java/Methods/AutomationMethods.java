package Methods;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import PageObjects.HomeObjects;
import io.appium.java_client.android.AndroidDriver;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by chrisp on 01/08/2016.
 */
public class AutomationMethods {

    AndroidDriver driver;
    HomeObjects objects;

    public AutomationMethods(AndroidDriver driver) {
        this.driver = driver;
        objects = new HomeObjects(driver);
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
}
