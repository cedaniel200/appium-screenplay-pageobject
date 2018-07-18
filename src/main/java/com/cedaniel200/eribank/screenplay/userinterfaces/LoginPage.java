package com.cedaniel200.eribank.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public final static Target USERNAME = Target.the("the username field")
            .located(By.id("com.experitest.ExperiBank:id/usernameTextField"));
    public final static Target PASSWORD = Target.the("the password field")
            .located(By.id("com.experitest.ExperiBank:id/passwordTextField"));
    public final static Target BUTTON_LOGIN = Target.the("the login button")
            .located(By.id("com.experitest.ExperiBank:id/loginButton"));

}
