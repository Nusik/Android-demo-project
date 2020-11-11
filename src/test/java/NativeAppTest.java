import app.CalculatorMainView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class NativeAppTest {

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

        calculatorMainView.getDigit2().click();
        calculatorMainView.getPlusButton().click();
        calculatorMainView.getDigit4().click();
        calculatorMainView.getEqualButton().click();

        assertEquals(calculatorMainView.getResultField().getText(), "6");
    }

    @Test
    public void multiplicationTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit6().click();
        calculatorMainView.getMultiplyButton().click();
        calculatorMainView.getDigit9().click();
        calculatorMainView.getEqualButton().click();

        assertEquals(calculatorMainView.getResultField().getText(), "54");
    }

    @Test
    public void percentageIntegerTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit9().click();
        calculatorMainView.getDigit0().click();
        calculatorMainView.getPlusButton().click();
        calculatorMainView.getDigit4().click();
        calculatorMainView.getExtandPanel().click();
        calculatorMainView.getPercentageButton();
        calculatorMainView.getNumbersPad().click();
        calculatorMainView.getEqualButton().click();

        assertEquals(calculatorMainView.getResultField().getText(), "93.6");

        calculatorMainView.getClearButton().click();
    }

    @Test
    public void percentageFractionalTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit6().click();
        calculatorMainView.getDigit0().click();
        calculatorMainView.getMinusButton().click();
        calculatorMainView.getDigit4().click();
        calculatorMainView.getPointButton().click();
        calculatorMainView.getDigit2().click();
        calculatorMainView.getExtandPanel().click();
        calculatorMainView.getPercentageButton();
        calculatorMainView.getCloseAdditionalPanel().click();
        calculatorMainView.getEqualButton().click();

        assertEquals(calculatorMainView.getResultField().getText(), "57.48");
    }

}
