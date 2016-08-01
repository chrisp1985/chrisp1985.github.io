package Methods;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 01/08/2016.
 */
public class AutomationMethods {

    AndroidDriver driver;
    public AutomationMethods(AndroidDriver driver) {
        this.driver = driver;
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
}
