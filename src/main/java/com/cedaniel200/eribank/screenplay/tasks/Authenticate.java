package com.cedaniel200.eribank.screenplay.tasks;

import com.cedaniel200.eribank.screenplay.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.cedaniel200.eribank.screenplay.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Authenticate implements Task {

    private User user;

    public Authenticate(User user) {
        this.user = user;
    }

    public static Authenticate the(User user){
        return instrumented(Authenticate.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME),
                Enter.theValue(user.getPassword()).into(PASSWORD),
                Click.on(BUTTON_LOGIN)
        );
    }
}
