import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileTest {
    private static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void chrome_test() throws InterruptedException {
        // driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
        // driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        driver.findElement(By.id("com.android.chrome:id/search_box_text")).click();
        driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("hello");
        Thread.sleep(2000); // bad practice!! just to see results!
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}