package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorMainView {

    AppiumDriver appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_2')]")
    public MobileElement digit2;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_4')]")
    public MobileElement digit4;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_6')]")
    public MobileElement digit6;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_9')]")
    public MobileElement digit9;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_0')]")
    public MobileElement digit0;

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

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id, 'arrow')]")
    public MobileElement extandPanel;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id, 'arrow')]")
    public MobileElement closeAdditionalPanel;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id, 'pad_numeric')]")
    public MobileElement numbersPad;


    public CalculatorMainView(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public MobileElement getDigit2() {
        return digit2;
    }

    public MobileElement getDigit4() {
        return digit4;
    }

    public MobileElement getDigit6() {
        return digit6;
    }

    public MobileElement getDigit0() {
        return digit0;
    }

    public MobileElement getDigit9() {
        return digit9;
    }

    public MobileElement getPointButton() {
        return pointButton;
    }

    public MobileElement getMinusButton() {
        return minusButton;
    }

    public MobileElement getPlusButton() {
        return plusButton;
    }

    public MobileElement getMultiplyButton() {
        return multiplyButton;
    }

    public MobileElement getEqualButton() {
        return equalButton;
    }

    public MobileElement getPercentageButton() {
        return percentageButton;
    }

    public MobileElement getResultField() {
        return resultField;
    }

    public MobileElement getClearButton() {
        return clearButton;
    }

    public MobileElement getExtandPanel() {
        return extandPanel;
    }

    public MobileElement getNumbersPad() {
        return numbersPad;
    }


    public MobileElement getCloseAdditionalPanel() {
        return closeAdditionalPanel;
    }

}

