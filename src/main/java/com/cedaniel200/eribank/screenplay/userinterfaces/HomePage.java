package com.cedaniel200.eribank.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public final static Target BUTTON_MAKE_PAYMENT = Target.the("the payment button")
            .located(By.id("com.experitest.ExperiBank:id/makePaymentButton"));
}
