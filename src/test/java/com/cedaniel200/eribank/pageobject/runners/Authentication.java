package com.cedaniel200.eribank.pageobject.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/authentication.feature",
        glue = "com.cedaniel200.eribank.pageobject.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class Authentication {
}
