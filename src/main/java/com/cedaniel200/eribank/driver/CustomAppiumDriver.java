package com.cedaniel200.eribank.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import net.thucydides.core.webdriver.DriverSource;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.URI;

/**
 * Levanta la sesión de Appium con la API nativa de java-client y se la entrega a Serenity ya
 * creada, para que no intente configurarla con comandos web que UiAutomator2 rechaza.
 *
 * <p>Los valores salen del bloque {@code mobile} de {@code serenity.conf}; cualquier clave se puede
 * sobrescribir con {@code -Dmobile.<clave>=valor}.</p>
 */
public class CustomAppiumDriver implements DriverSource {

    private static final Config MOBILE = ConfigFactory.parseResources("serenity.conf").getConfig("mobile");

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
                .setPlatformVersion(value("android.platform.version", "9"))
                .setDeviceName(value("android.device.name", "emulator-5554"))
                .setAppPackage(value("android.app.package", "com.experitest.ExperiBank"))
                .setAppActivity(value("android.app.activity", "com.experitest.ExperiBank.LoginActivity"))
                .setNoReset(Boolean.parseBoolean(value("app.no.reset", "true")));
        options.setCapability("appium:forceAppLaunch", true);
        return new AndroidDriver(URI.create(value("hub", "http://127.0.0.1:4723")).toURL(), options);
    }

    private WebDriver iosDriver() throws Exception {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformVersion(value("ios.platform.version", "17"))
                .setDeviceName(value("ios.device.name", "iPhone 15"))
                .setBundleId(value("ios.app.bundle.id", "com.experitest.ExperiBank"))
                .setNoReset(Boolean.parseBoolean(value("app.no.reset", "true")));
        options.setCapability("appium:forceAppLaunch", true);
        return new IOSDriver(URI.create(value("hub", "http://127.0.0.1:4723")).toURL(), options);
    }

    /**
     * Prioridad: variable de entorno MOBILE_<CLAVE>, luego -Dmobile.<clave>, luego el bloque
     * mobile de serenity.conf, luego el valor por defecto. Se lee el archivo directamente porque la instancia de EnvironmentVariables que
     * recibe el DriverSource no incluye ese bloque.
     */
    private String value(String key, String fallback) {
        String fromEnvironment = System.getenv("MOBILE_" + key.toUpperCase().replace('.', '_'));
        if (fromEnvironment != null) {
            return fromEnvironment;
        }
        String property = System.getProperty("mobile." + key);
        if (property != null) {
            return property;
        }
        return MOBILE.hasPath(key) ? MOBILE.getString(key) : fallback;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
