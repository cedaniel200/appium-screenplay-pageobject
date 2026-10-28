package com.cedaniel200.eribank.pageobject.steps;

import com.cedaniel200.eribank.pageobject.pages.HomePage;
import com.cedaniel200.eribank.pageobject.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AUser {

    private final LoginPage loginPage;
    private final HomePage homePage;

    public AUser(AndroidDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Step
    public void tryToLogin(String username, String password) {
        loginPage.tryLogin(username, password);
    }

    @Step
    public void shouldSeeHomePage() {
        assertThat(homePage.isButtonMakePaymentVisible(), is(true));
    }
}
