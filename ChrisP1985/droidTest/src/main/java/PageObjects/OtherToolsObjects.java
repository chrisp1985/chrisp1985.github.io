package PageObjects;

import org.openqa.selenium.WebElement;

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
        return null;
    }

    @Override
    public WebElement itemsMenu() {
        return null;
    }

    @Override
    public WebElement pageHeading() {
        return null;
    }

    @Override
    public WebElement pageDescription() {
        return null;
    }
}
