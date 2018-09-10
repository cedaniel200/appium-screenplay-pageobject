package com.cedaniel200.eribank.screenplay.cloud;

import com.cedaniel200.eribank.screenplay.questions.TheHomePage;
import com.cedaniel200.eribank.screenplay.tasks.Authenticate;
import com.cedaniel200.eribank.screenplay.util.AppiumDriverProviderAWS;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.cedaniel200.eribank.screenplay.model.builder.UserBuilder.user;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class AuthenticationCloud {


    private WebDriver driver;
    private Actor cesar = Actor.named("Cesar");

    @Before
    public void prepareStage() {
        driver = AppiumDriverProviderAWS.getDriver();
        cesar.can(BrowseTheWeb.with(driver));
    }

    @Test
    public void iLogin() {
        cesar.attemptsTo(Authenticate.the(user("company").withPassword("company")));

        cesar.should(seeThat(TheHomePage.isVisible()));
    }
}
