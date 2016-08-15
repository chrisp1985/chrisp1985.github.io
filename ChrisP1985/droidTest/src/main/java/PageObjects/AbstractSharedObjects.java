package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 15/08/2016.
 */
public abstract class AbstractSharedObjects {
    AndroidDriver driver;

    public AbstractSharedObjects(AndroidDriver incomingDriver) {
        driver = incomingDriver;
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
    public WebElement drawerList() {
        return new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/design_navigation_view")));
    }

    public List<WebElement> menuItems() {
        return drawerList().findElements(By.className("android.support.v7.widget.LinearLayoutCompat"));
    }

    public List<String> menuItemsStrings() {
        List<String> menuItems = new ArrayList<>();
        for(WebElement item: menuItems()) {
            int itemsSize = menuItems().size();
            String itemFound = item.findElement(By.className("android.widget.CheckedTextView")).getText();
            menuItems.add(itemFound);
        }
        return menuItems;
    }
}
