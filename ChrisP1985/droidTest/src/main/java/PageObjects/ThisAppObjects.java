package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 15/08/2016.
 */
public class ThisAppObjects extends AbstractSharedObjects implements ExamplesPages {

    public ThisAppObjects(AndroidDriver incomingDriver) {
        super(incomingDriver);
    }

    @Override
    public WebElement pageImage() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("")));
    }

    @Override
    public WebElement itemsMenu() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("")));
    }

    @Override
    public WebElement pageHeading() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("")));
    }

    @Override
    public WebElement pageDescription() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("")));
    }
}
