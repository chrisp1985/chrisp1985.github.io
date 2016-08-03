package tests;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.net.MalformedURLException;

import Methods.AutomationMethods;
import Methods.CreateDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 01/08/2016.
 *
 *
 */
@Ignore
public class DroidTests {

    private AndroidDriver driver;

    @Before
    public void setupTest() throws MalformedURLException {
        // Execute the setup steps.
        driver = new CreateDriver().setupDriver();
    }

    @Test
    public void doStuff() {
        new AutomationMethods(driver).takeAScreenShot("hello");
        System.out.println("HELLO");
    }
}
