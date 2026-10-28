package com.cedaniel200.eribank.screenplay.questions;

import com.cedaniel200.eribank.screenplay.userinterfaces.HomePage;
import com.cedaniel200.eribank.support.MobileDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the home page is visible")
public class TheHomePage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return MobileDriver.in(actor).findElement(HomePage.BUTTON_MAKE_PAYMENT).isDisplayed();
    }

    public static TheHomePage isVisible() {
        return new TheHomePage();
    }
}
