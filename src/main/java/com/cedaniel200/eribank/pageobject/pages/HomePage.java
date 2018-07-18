package com.cedaniel200.eribank.pageobject.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(id = "com.experitest.ExperiBank:id/makePaymentButton")
    private WebElement buttonMakePayment;

    public boolean isButtonMakePaymentVisible() {
       return this.buttonMakePayment.isDisplayed();
    }

}
