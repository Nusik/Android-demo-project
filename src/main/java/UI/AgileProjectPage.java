package UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AgileProjectPage extends BasePage {

    private By welcomeMessage = By.cssSelector(".heading3");

    public boolean isWelcomeMessagePresent() {
        return welcomeMessage.isDisplayed();
    }

    public AgileProjectPage(AppiumDriver driver) {
        appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }
}
