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
                .name("selenium_tools_image")));
    }

    @Override
    public WebElement pageHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("tools_heading")));
    }

    public WebElement toolsDisplayedHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("tools_displayed_heading")));
    }

    @Override
    public WebElement pageDescription() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("changeable_tools_summary")));
    }

    @Override
    public List<WebElement> tabItems() {
        return genericItemsMenu().findElements(By.className("android.widget.TextView"));
    }

    public WebElement progressBar() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("webview_progress_bar")));
    }

    public WebElement toolsWebPage() {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.webkit.WebView[@content-desc='Chris Parsons WebSite']" +
                        "/android.view.View[@content-desc='Tools and Frameworks']")));
    }

    @Override
    public WebElement webViewButton() {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.Button[@text='Switch To WebView']")));
    }
}
