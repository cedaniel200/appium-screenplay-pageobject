package com.cedaniel200.eribank.pageobject.stepdefinitions;

import com.cedaniel200.eribank.pageobject.steps.AUser;
import com.cedaniel200.eribank.support.MobileDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AuthenticationStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    private AUser user() {
        return new AUser(MobileDriver.in(theActorInTheSpotlight()));
    }

    @When("^I login with username (.*) and password (.*)$")
    public void iLogin(String username, String password) {
        theActorCalled("Cesar");
        user().tryToLogin(username, password);
    }

    @Then("^you should see the home page$")
    public void youShouldSeeTheHome() {
        user().shouldSeeHomePage();
    }
}
