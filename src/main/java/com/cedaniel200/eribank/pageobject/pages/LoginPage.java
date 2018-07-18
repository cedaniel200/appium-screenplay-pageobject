package com.cedaniel200.eribank.pageobject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
    public WebElement username;
    @FindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
    public WebElement password;
    @FindBy(id = "com.experitest.ExperiBank:id/loginButton")
    public WebElement buttonLogin;

}
