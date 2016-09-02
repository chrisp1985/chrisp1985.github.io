package tests;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by chrisp on 26/08/2016.
 * Test suite for the Open Website link.
 */
@Ignore
public class OpenWebsiteTests extends AbstractTestSetup {

    @Test
    public void checkThatLinkOpensWebsite() {
        // Click on the 'My Website' link.
        methods.navigateToScreen("My Website");

        // Check that a toaster appears.

        // Check that a browser is displayed.
    }
}
