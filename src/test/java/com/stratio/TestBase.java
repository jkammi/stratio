package com.stratio;

import com.codeborne.selenide.Configuration;
import com.stratio.helpers.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    public String mainPage = "https://www.stratio.com/";

    @BeforeAll
    static void configure() {

//        WebDriverManager.chromedriver().setup();

        // parametrized values:
        String remoteBrowserName = System.getProperty("remote_browser", "selenoid.autotests.cloud");
        String browserName = System.getProperty("browser_name", "chrome");
        String browserVersion = System.getProperty("browser_version", "100.0");

        Configuration.remote = "https://user1:1234@" + remoteBrowserName + "/wd/hub";
        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = "2000x1200";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 12000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

