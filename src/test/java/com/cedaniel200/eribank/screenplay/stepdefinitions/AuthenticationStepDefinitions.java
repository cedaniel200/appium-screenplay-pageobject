package com.cedaniel200.eribank.screenplay.stepdefinitions;

import com.cedaniel200.eribank.screenplay.model.builder.UserBuilder;
import com.cedaniel200.eribank.screenplay.questions.TheHomePage;
import com.cedaniel200.eribank.screenplay.tasks.Authenticate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
