package com.cedaniel200.eribank.pageobject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private static final By USERNAME_FIELD =
            AppiumBy.id("com.experitest.ExperiBank:id/usernameTextField");
    private static final By PASSWORD_FIELD =
            AppiumBy.id("com.experitest.ExperiBank:id/passwordTextField");
    private static final By LOGIN_BUTTON =
            AppiumBy.id("com.experitest.ExperiBank:id/loginButton");

    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tryLogin(String username, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
