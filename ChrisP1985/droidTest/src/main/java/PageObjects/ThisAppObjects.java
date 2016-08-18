package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 15/08/2016.
 */
public class ThisAppObjects extends AbstractSharedObjects {

    public ThisAppObjects(AndroidDriver incomingDriver) {
        super(incomingDriver);
    }

    public WebElement pageImage() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.example.chrisp.myapplication:id/bootstrapImage")));
    }

    public WebElement pageHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[.='Why have I done this?']")));
    }

    public WebElement thisAppDescHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[.='This Application']")));
    }
}
