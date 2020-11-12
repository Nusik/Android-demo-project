import app.CalculatorMainView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class NativeAppCalculatorTest {

    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @AfterClass
    public void close() {
        appiumDriver.quit();
    }

    @Test
    public void additionTest() throws Exception {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        int digit1 = 2;
        int digit2 = 4;
        int resultSum = digit1 + digit2;

        calculatorMainView.getDigitNumber(digit1).click();
        calculatorMainView.clickPlusButton();
        calculatorMainView.getDigitNumber(digit2).click();
        calculatorMainView.clickEqualButton();

        assertEquals(calculatorMainView.getResultField().getText(), String.valueOf(resultSum), "Actual result is wrong: "
                + calculatorMainView.getResultField().getText());
    }

    @Test
    public void multiplicationTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        int digit1 = 6;
        int digit2 = 9;
        int resultMultiply = digit1 * digit2;

        calculatorMainView.getDigitNumber(digit1).click();
        calculatorMainView.clickMultiplyButton();
        calculatorMainView.getDigitNumber(digit2).click();
        calculatorMainView.clickEqualButton();

        assertEquals(calculatorMainView.getResultField().getText(), String.valueOf(resultMultiply), "Actual result is wrong: "
                + calculatorMainView.getResultField().getText());
    }

    @Test
    public void percentageIntegerTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);

        String resultInteger = "93.6";

        calculatorMainView.getDigitNumber(9).click();
        calculatorMainView.getDigitNumber(0).click();
        calculatorMainView.clickPlusButton();
        calculatorMainView.getDigitNumber(4).click();
        calculatorMainView.clickPercentageButton();
        calculatorMainView.clickEqualButton();

        assertEquals(calculatorMainView.getResultField().getText(), resultInteger, "Actual result is wrong: "
                + calculatorMainView.getResultField().getText());
    }

    @Test
    public void percentageFractionalTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);

        String resultFractional = "57.48";

        calculatorMainView.getDigitNumber(6).click();
        calculatorMainView.getDigitNumber(0).click();
        calculatorMainView.clickMinusButton();
        calculatorMainView.getDigitNumber(4).click();
        calculatorMainView.clickPointButton();
        calculatorMainView.getDigitNumber(2).click();
        calculatorMainView.clickPercentageButton();
        calculatorMainView.clickEqualButton();

        assertEquals(calculatorMainView.getResultField().getText(), resultFractional, "Actual result is wrong: "
                + calculatorMainView.getResultField().getText());

        calculatorMainView.clickClearButton();
    }

}
