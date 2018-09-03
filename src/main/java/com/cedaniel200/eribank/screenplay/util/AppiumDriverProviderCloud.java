package com.cedaniel200.eribank.screenplay.util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AppiumDriverProviderCloud {

    public static WebDriver getDriver() {
        AppiumDriver<WebElement> driver;

        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("app", "D:/projects/eribank/src/test/resources/app/EriBank.apk");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
        capabilities.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AppiumDriver<WebElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        return driver;
    }
}