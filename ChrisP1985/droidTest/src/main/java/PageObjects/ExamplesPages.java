package PageObjects;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by chrisp on 15/08/2016.
 */
public interface ExamplesPages {

    WebElement pageImage();

    WebElement pageHeading();

    WebElement pageDescription();

    List<WebElement> tabItems();

    WebElement genericItemsMenu();

}
