package com.cedaniel200.eribank.screenplay.util;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverProviderAWS {

    public static WebDriver getDriver() {
        AndroidDriver<MobileElement> driver;


        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("platformName", "ANDROID");
        capabilities.setCapability("deviceName", "asdf");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
        capabilities.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
        capabilities.setCapability("noReset", true);


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
