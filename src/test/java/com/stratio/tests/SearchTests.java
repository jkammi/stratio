package com.stratio.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.stratio.TestBase;
import com.stratio.data.Tags;
import org.aspectj.apache.bcel.classfile.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @DisplayName("Correct work of the Search on the blog page")
    @ParameterizedTest(name = "Tag: {0}")
    @EnumSource(Tags.class)
    void SearchTest(Tags tag) {
        step("Opening the blog page", () -> {
            open(mainPage + "blog");
        });

        step("Clicking Search button", () -> {
            $(".actions .fa-search").click();
        });

        step("Enter the search request", () -> {
            $(".search-modal-box .search-field").setValue(tag.displayName()).pressEnter();
        });

        step("Check if the search request exists in the articles", () -> {
            ElementsCollection posts = $$("[id^='post-']");
            for (SelenideElement post : posts) {
                post.$(".post-title-alt a").scrollTo().click();

                $(".post-template-default").shouldHave(text(tag.displayName()));
                back();
            }
        });
    }
}
