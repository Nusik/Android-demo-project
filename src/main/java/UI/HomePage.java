package UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    protected By rootElement = By.cssSelector("div#navbar-brand-centered");
    protected By newTourButton = By.cssSelector("a[href*='newtours']");
    protected By agileProjectButton = By.cssSelector("a[href*='Agile'");
    protected By seleniumDropDown = By.cssSelector("a.dropdown-toggle");
    protected By tableDemoLink = By.cssSelector("a[href*='table'");

    public void clickNewTourButton() {
      $(rootElement).find(newTourButton).click();
    }

    public void clickAgileProjectButton() {
        $(rootElement).find(agileProjectButton).click();
    }

    public void clickTableDemoLink() {
        $(rootElement).find(tableDemoLink).click();
    }

    public HomePage(AppiumDriver driver) {
        appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public void navigate() {
        appiumDriver.get("http://demo.guru99.com/");
    }
}
