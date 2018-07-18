package com.cedaniel200.eribank.screenplay.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/authentication.feature",
        glue = "com.cedaniel200.eribank.screenplay.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class Authentication {

}
