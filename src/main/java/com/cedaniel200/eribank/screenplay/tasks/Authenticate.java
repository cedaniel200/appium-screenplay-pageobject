package com.cedaniel200.eribank.screenplay.tasks;

import com.cedaniel200.eribank.screenplay.models.User;
import com.cedaniel200.eribank.support.MobileDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.annotations.Step;

import static com.cedaniel200.eribank.screenplay.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Authenticate implements Task {

    private final User user;

    public Authenticate(User user) {
        this.user = user;
    }

    public static Authenticate the(User user) {
        return instrumented(Authenticate.class, user);
    }

    @Override
    @Step("{0} se autentica en la aplicación")
    public <T extends Actor> void performAs(T actor) {
        MobileDriver.in(actor).findElement(USERNAME).sendKeys(user.getUsername());
        MobileDriver.in(actor).findElement(PASSWORD).sendKeys(user.getPassword());
        MobileDriver.in(actor).findElement(BUTTON_LOGIN).click();
    }
}
