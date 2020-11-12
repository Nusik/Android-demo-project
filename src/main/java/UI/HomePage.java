package UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    protected By rootElement = By.cssSelector("div#navbar-brand-centered");
    protected By newTourButton = By.xpath("//a[contains(text(),'New Tours')]");
    protected By agileProjectButton = By.xpath("//a[contains(text(),'Agile Project')]");

    public HomePage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public void navigate() {
        appiumDriver.get("http://demo.guru99.com/");
    }

    public void clickAgileProjectButton() {
        appiumDriver.findElement(agileProjectButton).click();
    }

    public void clickNewToursButton() {
        appiumDriver.findElement(newTourButton).click();
    }
}
