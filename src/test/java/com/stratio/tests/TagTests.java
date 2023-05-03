package com.stratio.tests;

import com.codeborne.selenide.SelenideElement;
import com.stratio.TestBase;
import com.stratio.data.Tags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TagTests extends TestBase {

    @DisplayName("Correct work of the filter by Tags on the blog page")
    @ParameterizedTest(name = "Tag: {0}")
    @EnumSource(Tags.class)
    @Tag("tags")
    void testFilterArticlesByTags(Tags tag) {
        step("Opening the blog.stratio.com page", () -> {
            open(mainPage + "blog");
        });

        step("Clicking on tag", () -> {
            $(".tagcloud").$(byText(tag.displayName())).scrollTo().click();
        });

        step("Check if the title is correct: {0}", () -> {
            $(".archive-head .title").shouldHave(text(tag.displayName()));
        });

        step("Opening the first article in the list by tag {0}", () -> {
            $("[id^=post-] .post-title-alt a").scrollTo().click();

        });

        step("Checking if the tag {0} are located under the first article", () -> {
            List<SelenideElement> postElements = $$(("[id^=post-]"));
            for (SelenideElement postElement : postElements) {
            $(".the-post .post-tags").shouldHave(text(tag.displayName()));
            }
        });
    }
}
