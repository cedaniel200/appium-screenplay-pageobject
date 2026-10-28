package com.cedaniel200.eribank.support;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

/**
 * Devuelve el AndroidDriver real que Serenity tiene detrás del actor.
 *
 * <p>Serenity envuelve el driver en un WebDriverFacade y resuelve los elementos con selectores
 * web (CSS/JS), que UiAutomator2 no soporta. Trabajar con el driver nativo evita esa traducción
 * sin perder los reportes.</p>
 */
public final class MobileDriver {

    private MobileDriver() {
    }

    public static AndroidDriver in(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriver proxied = driver instanceof WebDriverFacade facade ? facade.getProxiedDriver() : driver;
        return (AndroidDriver) proxied;
    }
}
