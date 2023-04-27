package com.stratio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TitlesTests extends TestBase {

    private static final String HOME_TITLE = "Augmented Data Fabric";
    private static final String PRODUCT_TITLE = "One single product for automated AI Data management";
    String mainPage = "https://www.stratio.com/";

    @Test
    @Tag("simple")
    @DisplayName("The title on a /home page is correct")
    void mainPageTitleTest() {
        step("Opening the main page", () -> {
            open(mainPage + "home");
        });

        step("Declining cookies", () -> {
            $("button.clear-plus").click();
        });

        step("Checking if this text exists:" + HOME_TITLE, () -> {
            $("#section-augmented-data-centric").shouldHave(text(HOME_TITLE));
        });
    }

    @Test
    @Tag("simple")
    @DisplayName("The title on a /product page is correct")
    void blogPageTitleTest() {
        step("Opening the main page", () -> {
            open(mainPage);
        });

        step("Click on the button Know More", () -> {
            $("button.custom-button").hover().click();
        });

        step("Checking if this text exists:" + PRODUCT_TITLE, () -> {
            $("div.subsection-header").shouldHave(text(PRODUCT_TITLE));
        });
    }
}
