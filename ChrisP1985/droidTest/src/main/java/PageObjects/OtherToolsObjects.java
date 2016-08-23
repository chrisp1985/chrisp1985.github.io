package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 15/08/2016.
 */
public class OtherToolsObjects extends AbstractSharedObjects implements ExamplesPages {

    public OtherToolsObjects(AndroidDriver incomingDriver) {
        super(incomingDriver);
    }

    @Override
    public WebElement pageImage() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("jenkins_other_tools_image")));
    }

    @Override
    public WebElement pageHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("other_tools_heading")));
    }

    public WebElement otherToolsDisplayedHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("other_tools_displayed_heading")));
    }

    @Override
    public WebElement pageDescription() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("changeable_other_tools_summary")));
    }

    @Override
    public List<WebElement> tabItems() {
        return genericItemsMenu().findElements(By.className("android.widget.TextView"));
    }
}
