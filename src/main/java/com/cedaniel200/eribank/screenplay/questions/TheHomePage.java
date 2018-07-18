package com.cedaniel200.eribank.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.cedaniel200.eribank.screenplay.userinterfaces.HomePage.BUTTON_MAKE_PAYMENT;

@Subject("the home page is visible")
public class TheHomePage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return BUTTON_MAKE_PAYMENT.resolveFor(actor).isVisible();
    }

    public static TheHomePage isVisible() {
        return new TheHomePage();
    }
}
