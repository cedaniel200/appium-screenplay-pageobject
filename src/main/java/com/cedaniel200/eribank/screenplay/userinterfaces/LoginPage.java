package com.cedaniel200.eribank.screenplay.userinterfaces;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage {

    public static final By USERNAME = AppiumBy.id("com.experitest.ExperiBank:id/usernameTextField");
    public static final By PASSWORD = AppiumBy.id("com.experitest.ExperiBank:id/passwordTextField");
    public static final By BUTTON_LOGIN = AppiumBy.id("com.experitest.ExperiBank:id/loginButton");
}
