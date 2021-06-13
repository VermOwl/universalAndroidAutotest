package example.system;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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

//    public AndroidDriver initialization() throws MalformedURLException {
//
//        DesiredCapabilities dc = new DesiredCapabilities();
//
//        dc.setCapability("deviceName", "autotest");
//        //dc.setCapability("platformName", "Android");
//        dc.setCapability("app", "/Users/vermowl/Downloads/universal.apk");
//        dc.setCapability("autoGrantPermissions", true);
//
//        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        return (AndroidDriver) driver;
//    }

    public AndroidDriver connectToDevice() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("app", "/root/universal.apk");
        dc.setCapability("autoGrantPermissions", true);


        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return (AndroidDriver) driver;
    }

    public AndroidDriver connectToDeviceWithCamera() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appActivity", "com.android.camera2");
        dc.setCapability("autoGrantPermissions", true);


        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return (AndroidDriver) driver;
    }

    public AndroidDriver browserStack() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "stepanzavadskiy2");
        caps.setCapability("browserstack.key", "unASUrndM731cKcyXBGy");

        // Set URL of the application under test
        caps.setCapability("app", "bs://<app-id>");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        return driver;
    }
}