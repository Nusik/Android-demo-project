package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CalculatorMainView {

    AppiumDriver appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'dec_point')]")
    public MobileElement pointButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_add')]")
    public MobileElement plusButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_sub')]")
    public MobileElement minusButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_mul')]")
    public MobileElement multiplyButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'eq')]")
    public MobileElement equalButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_pct')]")
    public MobileElement percentageButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'result')]")
    public MobileElement resultField;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'clr')]")
    public MobileElement clearButton;

    public CalculatorMainView(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public WebElement getDigitNumber(int digitNumber) {
        return appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_" + digitNumber + "')]"));
    }

    public MobileElement getResultField() {
        return resultField;
    }

    public void clickPointButton() {
        pointButton.click();
    }

    public void clickMinusButton() {
        minusButton.click();
    }

    public void clickPlusButton() {
        plusButton.click();
    }

    public void clickMultiplyButton() {
        multiplyButton.click();
    }

    public void clickEqualButton() {
        equalButton.click();
    }

    public void clickPercentageButton() {
        percentageButton.click();
    }

    public void clickClearButton() {
        clearButton.click();
    }

}

