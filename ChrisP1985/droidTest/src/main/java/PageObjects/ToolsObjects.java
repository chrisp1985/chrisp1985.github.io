package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 15/08/2016.
 *
 */
public class ToolsObjects extends AbstractSharedObjects implements ExamplesPages {

    public ToolsObjects(AndroidDriver incomingDriver) {
        super(incomingDriver);
    }

    @Override
    public WebElement pageImage() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/seleniumImg")));
    }

    @Override
    public WebElement itemsMenu() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .id("android:id/tabs")));
    }

    @Override
    public WebElement pageHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[.='Tools and Frameworks']")));
    }

    @Override
    public WebElement pageDescription() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/tools_summary")));
    }

    public List<WebElement> tabItems() {
        return itemsMenu().findElements(By.className("android.widget.LinearLayout"));
    }
}
