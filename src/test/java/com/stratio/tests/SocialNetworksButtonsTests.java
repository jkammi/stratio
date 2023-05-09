package com.stratio.tests;

import com.codeborne.selenide.Condition;
import com.stratio.TestBase;
import com.stratio.data.SocialNetworks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class SocialNetworksButtonsTests extends TestBase {

    @DisplayName("Links of the buttons of social network")
    @Tag("social_buttons")
    @ParameterizedTest
    @EnumSource(SocialNetworks.class)
    void socialNetworksButtons(SocialNetworks sn) {
        step("Opening the blog page", () -> {
            open(mainPage + "blog");
        });

        step("Checking the link of the button", () -> {
            String buttonSelector = ".actions .social-icons .fa-" + sn.name();
            $(buttonSelector).shouldHave(Condition.attribute("href", sn.displayName()));
        });
    }
}
