package com.cedaniel200.eribank.pageobject.steps;

import com.cedaniel200.eribank.pageobject.pages.HomePage;
import com.cedaniel200.eribank.pageobject.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AUser {

    @Steps
    LoginPage loginPage;
    @Steps
    HomePage homePage;

    @Step
    public void tryToLogin(String username, String password) {
        loginPage.tryLogin(username, password);
    }

    @Step
    public void shouldSeeHomePage() {
        assertThat(homePage.isButtonMakePaymentVisible(), is(true));
    }

}
