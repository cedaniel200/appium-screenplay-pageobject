package com.cedaniel200.eribank.screenplay.stepdefinitions;

import com.cedaniel200.eribank.screenplay.models.builder.UserBuilder;
import com.cedaniel200.eribank.screenplay.questions.TheHomePage;
import com.cedaniel200.eribank.screenplay.tasks.Authenticate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AuthenticationStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^I login with username (.*) and password (.*)$")
    public void iLogin(String username, String password) throws Throwable {
        theActorCalled("Cesar").attemptsTo(Authenticate.the(UserBuilder.user(username).withPassword(password)));
    }

    @Then("^you should see the home page$")
    public void youShouldSeeTheHome() throws Throwable {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheHomePage.isVisible()));
    }

}
