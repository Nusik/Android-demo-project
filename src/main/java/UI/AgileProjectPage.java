package UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AgileProjectPage extends BasePage {

    protected By emailInput = By.xpath("//input[@name='uid']");
    protected By passwordInput = By.xpath("//input[@name='password']");
    protected By logoutButton = By.xpath("//a[contains(text(),'Log out')]");
    protected By welcomeMessage = By.xpath("//marquee[@class='heading3']");

    public AgileProjectPage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public void enterCredentials(String login, String password) {
        appiumDriver.findElement(emailInput).sendKeys(login);
        appiumDriver.findElement(passwordInput).sendKeys(password + Keys.ENTER);
    }

    public void clickLogoutButton() {
        appiumDriver.findElement(logoutButton).click();
    }

    public String getWelcomeMessage() {
        return appiumDriver.findElement(welcomeMessage).getText();
    }

    public void closeAlert() {
        Alert alert = appiumDriver.switchTo().alert();
        alert.accept();
    }
}
