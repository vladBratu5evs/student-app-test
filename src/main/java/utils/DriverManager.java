package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static utils.ConfigHelper.*;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Singleton pattern
    public static WebDriver getInstance() {
        if (driverThreadLocal.get() == null) {
            if (getConfig().getBoolean("student.app.run.locally")) {
                driverThreadLocal.set(configureLocal());
            } else {
                driverThreadLocal.set(configureRemote());
            }
        }
        return driverThreadLocal.get();
    }

    private static RemoteWebDriver configureRemote() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("macOS 10.14");
        browserOptions.setBrowserVersion("106");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "selenium-build-RQYSF");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://oauth-brvl92-2b8b3:4b6be83d-ea05-4d38-89a7-616570e154e8@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return new RemoteWebDriver(url, browserOptions);
    }

    private static WebDriver configureLocal() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}