package UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NewToursPage extends BasePage {

    protected By mainFragment = By.xpath("//nav[@class='navbar navbar-default']");

    public NewToursPage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public boolean isMainFragmentPresent() {
        return appiumDriver.findElement(mainFragment).isDisplayed();
    }

}
