package com.cedaniel200.eribank.pageobject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage {

    private static final By MAKE_PAYMENT_BUTTON =
            AppiumBy.id("com.experitest.ExperiBank:id/makePaymentButton");

    private final AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isButtonMakePaymentVisible() {
        return driver.findElement(MAKE_PAYMENT_BUTTON).isDisplayed();
    }
}
