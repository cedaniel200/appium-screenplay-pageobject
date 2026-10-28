package com.cedaniel200.eribank.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

/**
 * Levanta la sesión de Appium con la API nativa de java-client y se la entrega a Serenity ya
 * creada, para que no intente configurarla con comandos web que UiAutomator2 rechaza.
 *
 * <p>Los valores salen de {@code mobile.properties}; cualquier clave se puede sobrescribir con
 * {@code -Dclave=valor}.</p>
 */
public class CustomAppiumDriver implements DriverSource {

    private final Properties config = loadConfig();

    @Override
    public WebDriver newDriver() {
        String platform = value("platform", "android").toLowerCase();
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
                .setPlatformVersion(value("platform.version", "9"))
                .setDeviceName(value("device.name", "emulator-5554"))
                .setAppPackage(value("app.package", "com.experitest.ExperiBank"))
                .setAppActivity(value("app.activity", "com.experitest.ExperiBank.LoginActivity"))
                .setNoReset(Boolean.parseBoolean(value("app.no.reset", "true")));
        options.setCapability("appium:forceAppLaunch", true);
        return new AndroidDriver(URI.create(value("appium.hub", "http://127.0.0.1:4723")).toURL(), options);
    }

    private WebDriver iosDriver() throws Exception {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformVersion(value("ios.platform.version", "17"))
                .setDeviceName(value("ios.device.name", "iPhone 15"))
                .setBundleId(value("app.bundle.id", "com.experitest.ExperiBank"))
                .setNoReset(Boolean.parseBoolean(value("app.no.reset", "true")));
        options.setCapability("appium:forceAppLaunch", true);
        return new IOSDriver(URI.create(value("appium.hub", "http://127.0.0.1:4723")).toURL(), options);
    }

    /** Propiedad del sistema si existe; si no, el valor del archivo; si no, el valor por defecto. */
    private String value(String key, String fallback) {
        return System.getProperty(key, config.getProperty(key, fallback));
    }

    private static Properties loadConfig() {
        Properties properties = new Properties();
        try (InputStream in = CustomAppiumDriver.class.getClassLoader()
                .getResourceAsStream("mobile.properties")) {
            if (in != null) {
                properties.load(in);
            }
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer mobile.properties", e);
        }
        return properties;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
