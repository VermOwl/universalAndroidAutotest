package example.system;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;


public class Initialization {

    public AndroidDriver initialization() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("app", "/Users/vermowl/Downloads/universal.apk");
        dc.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return (AndroidDriver) driver;
    }

    public AndroidDriver connectToDevice() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appActivity", "Universal Electric");

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return (AndroidDriver) driver;
    }
}