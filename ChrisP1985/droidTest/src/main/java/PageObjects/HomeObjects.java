package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 09/08/2016.
 */
public class HomeObjects extends AbstractSharedObjects {

    public HomeObjects(AndroidDriver incomingDriver) {
        super(incomingDriver);
    }

    public WebElement homeTitle() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[contains(@text, 'My App')]")));
    }

    public WebElement carousel() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .name("carousel_view")));
    }
}
