package com.stratio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Simple_tests {

    private static final String HOME_TITLE = "Augmented Data Fabric";
    private static final String PRODUCT_TITLE = "One single product for automated AI Data management";


    @BeforeEach
    static void configure() {
        WebDriverManager.chromedriver().setup();
        step("Opening the main page", () -> {
            open("https://www.stratio.com/home");
        });
    }

    @Test
    @Tag("simple")
    void simpleTest() {
        step("Declining cookies", () -> {
            $("button.clear-plus").click(); // decline cookies
        });

        sleep(10000);

        step("Checking if this text exists:" + HOME_TITLE, () -> {
            $("#section-augmented-data-centric").shouldHave(text(HOME_TITLE));
        });
    }

    @Test
    @Tag("simple")
    void simpleTest2() {
        step("Click on the button Know More", () -> {
            $("button.custom-button").hover().click();
        });

        step("Checking if this text exists:" + PRODUCT_TITLE, () -> {
            $("div.subsection-header").shouldHave(text(PRODUCT_TITLE));
        });
    }

}
