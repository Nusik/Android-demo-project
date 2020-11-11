import UI.HomePage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class MobileWebTest {

    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//        capabilities.setCapability("chromedriverExecutableDir", "");

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @AfterClass
    public void close() {
        appiumDriver.quit();
    }

    @Test
    public void Test1() throws Exception {
        HomePage homePage = new HomePage(appiumDriver);
        homePage.navigate();
    }




}
