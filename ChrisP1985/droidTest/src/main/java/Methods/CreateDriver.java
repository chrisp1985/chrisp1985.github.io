package Methods;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 01/08/2016.
 */
public class CreateDriver {
    /**
     * *** SETUP THE DRIVER ***
     *
     * @return The setup driver.
     */
    public AndroidDriver setupDriver() throws MalformedURLException {
        // Set the apk path
        File projectDirectory = new File(System.getProperty("user.dir"));
        File applicationDirectory = new File(projectDirectory, "app\\build\\outputs\\apk\\app-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", applicationDirectory.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        return driver;
    }
}
