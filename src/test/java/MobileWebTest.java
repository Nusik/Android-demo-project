import UI.AgileProjectPage;
import UI.HomePage;
import UI.NewToursPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

public class MobileWebTest {

    AppiumDriver appiumDriver;
    HomePage homePage;
    AgileProjectPage agileProjectPage;
    NewToursPage newToursPage;

    protected String login = "1303";
    protected String password = "Guru99";
    protected String wrongLogin = "111";
    protected String wrongPassword = "xyz";

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("chromedriverExecutableDir",
                "C:\\Users\\User\\.m2\\repository\\webdriver\\chromedriver\\win32\\86.0.4240.22");

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @AfterClass
    public void close() {
        appiumDriver.quit();
    }

    @Test
    public void unloginTest() {
        homePage.navigate();
        homePage.clickAgileProjectButton();
        agileProjectPage.enterCredentials(login, password);
        agileProjectPage.clickLogoutButton();
    }

    @Test
    public void happyLogin() {
        homePage.navigate();
        homePage.clickAgileProjectButton();
        agileProjectPage.enterCredentials(login, password);

        assertTrue(true, agileProjectPage.getWelcomeMessage());
    }

    @Test
    public void unhappyLogin() {
        homePage.navigate();
        homePage.clickAgileProjectButton();
        agileProjectPage.enterCredentials(wrongLogin, wrongPassword);

        agileProjectPage.closeAlert();
    }

    @Test
    public void newToursPageNavigation() {
        homePage.navigate();
        homePage.clickNewToursButton();

        assertTrue(newToursPage.isMainFragmentPresent());
    }

}
