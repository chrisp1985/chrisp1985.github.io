package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 09/08/2016.
 */
public class HomeObjects {

    AndroidDriver driver;
    public HomeObjects(AndroidDriver incomingDriver) {
        driver = incomingDriver;
    }

    public WebElement homeTitle() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[contains(@text, 'My App')]")));
    }

    public WebElement carousel() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/containerViewPager")));
    }

    public WebElement menuButton() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(menu()))
                .findElement(By.className("android.widget.ImageButton"));
    }

    public WebElement menu() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/toolbar")));

    }

    public WebElement drawerElement() {
        return new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/design_navigation_view")));
    }

    public WebElement monkeyToolBar() {
        return new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/toolbarImage")));
    }
}
