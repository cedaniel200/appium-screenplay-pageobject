package com.cedaniel200.eribank.pageobject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

    private final AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isButtonMakePaymentVisible() {
        return driver.findElement(AppiumBy.id("com.experitest.ExperiBank:id/makePaymentButton")).isDisplayed();
    }
}
