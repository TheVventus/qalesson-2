package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class iOSTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("appium:deviceName","IPhone SE");
        capabilities.setCapability("appium:platformVersion","14.4");
        capabilities.setCapability("appium:udid","4CCCA2D1-0D40-4AE6-82F0-057C5D2D4CE0");
        capabilities.setCapability("appium:app","/Users/shuter/Desktop/JavaAppiumAutomation/apks/Wikipedia.app");

        driver = new IOSDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();
    }

    protected void tearDown() throws Exception {
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofDays(seconds));
    }
}
