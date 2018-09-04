package com.cedaniel200.eribank.screenplay.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AppiumDriverProviderAWS {

    public static WebDriver getDriver() {
        AndroidDriver<MobileElement> driver;

        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android"); // En la pagina estaba Android
        capabilities.setCapability("VERSION", "8.1.0");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android"); // En la pagina estaba Adroid
       // capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
        //capabilities.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver<MobileElement>(url, capabilities);

        return driver;
    }

}
