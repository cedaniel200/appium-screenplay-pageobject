package com.cedaniel200.eribank.pageobject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tryLogin(String username, String password) {
        driver.findElement(AppiumBy.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys(username);
        driver.findElement(AppiumBy.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys(password);
        driver.findElement(AppiumBy.id("com.experitest.ExperiBank:id/loginButton")).click();
    }
}
