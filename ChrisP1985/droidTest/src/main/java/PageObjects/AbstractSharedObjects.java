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

    public WebElement boundsOfScreen() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
                By.name("android.support.v4.widget.DrawerLayout")));
    }

    public WebElement menu() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("top_toolbar")));
    }

    public WebElement monkeyToolBar() {
        return new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By
                .name("mankey_toolbar_icon")));
    }

    public WebElement drawerList() {
        return new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By
                .className("android.support.v7.widget.RecyclerView")));
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

    public WebElement genericItemsMenu() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .className("android.widget.TabWidget")));
    }
}
