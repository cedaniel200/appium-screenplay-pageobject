package com.cedaniel200.eribank.pageobject.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationStepDefinitions {

    @When("^I login with username (.*) and password (.*)$")
    public void iLogin(String username, String password) throws Throwable {

    }

    @Then("^you should see the home page$")
    public void youShouldSeeTheHome() throws Throwable {

    }

}
