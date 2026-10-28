package com.cedaniel200.eribank.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

import java.net.URI;

/**
 * Levanta la sesión de Appium con la API nativa de java-client y se la entrega a Serenity ya
 * creada, para que no intente configurarla con comandos web que UiAutomator2 rechaza.
 *
 * <p>La plataforma se elige por configuración, no en el código: {@code -Dplatform=android|ios}
 * (por defecto Android).</p>
 */
public class CustomAppiumDriver implements DriverSource {

    private static final String HUB = System.getProperty("appium.hub", "http://127.0.0.1:4723");

    @Override
    public WebDriver newDriver() {
        String platform = System.getProperty("platform", "android").toLowerCase();
        try {
            return switch (platform) {
                case "android" -> androidDriver();
                case "ios" -> iosDriver();
                default -> throw new IllegalArgumentException(
                        "Plataforma no soportada: " + platform + " (usa android o ios)");
            };
        } catch (Exception e) {
            throw new IllegalStateException("No se pudo crear la sesión nativa de Appium", e);
        }
    }

    private WebDriver androidDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformVersion(System.getProperty("platform.version", "9"))
                .setDeviceName(System.getProperty("device.name", "emulator-5554"))
                .setAppPackage(System.getProperty("app.package", "com.experitest.ExperiBank"))
                .setAppActivity(System.getProperty("app.activity", "com.experitest.ExperiBank.LoginActivity"))
                .setNoReset(Boolean.parseBoolean(System.getProperty("app.no.reset", "true")));
        options.setCapability("appium:forceAppLaunch", true);
        return new AndroidDriver(URI.create(HUB).toURL(), options);
    }

    private WebDriver iosDriver() throws Exception {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformVersion(System.getProperty("platform.version", "17"))
                .setDeviceName(System.getProperty("device.name", "iPhone 15"))
                .setBundleId(System.getProperty("app.bundle.id", "com.experitest.ExperiBank"))
                .setNoReset(Boolean.parseBoolean(System.getProperty("app.no.reset", "true")));
        options.setCapability("appium:forceAppLaunch", true);
        return new IOSDriver(URI.create(HUB).toURL(), options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
