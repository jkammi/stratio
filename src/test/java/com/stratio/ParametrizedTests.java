package com.stratio;

import com.codeborne.selenide.SelenideElement;
import com.stratio.data.Category;
import com.stratio.data.Tags;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ParametrizedTests extends TestBase {

    String mainPage = "https://www.stratio.com/";

    @ParameterizedTest(name = "For category {0} on website blog.stratio.com are visible only articles with categories {0}")
    @EnumSource(Category.class)
    @org.junit.jupiter.api.Tag("parametrized")
    void testCategoriesExistOnWebsite(Category category) {
        step("Opening the blog.stratio.com page", () -> {
            open(mainPage + "blog");
        });

        step("Clicking on the category button", () -> {
            $("#cat.postform").click(); // click on the category button
        });

        step("Choosing the category", () -> {
            $("#cat").$(byText(String.valueOf(category))).click(); // choosing category
        });

        step("Each article on the website by filter {0} has category {0}", () -> {
            List<SelenideElement> postElements = $$(("[id^=post-]"));
            for (SelenideElement postElement : postElements) {
                postElement.$(".category").shouldHave(text(String.valueOf(category)));
            }
        });
    }

    @ParameterizedTest(name = "Negative test: For category {0} on website blog.stratio.com visible only articles with categories {0}")
    @EnumSource(Category.class)
    @Tag("parametrized")
    void negativeTestArticlesBlog(Category category) {
        step("Opening the blog.stratio.com page", () -> {
            open(mainPage + "blog");
        });

        step("Checking if all articles on blog.stratio.com has a category BLOG", () -> {
            List<SelenideElement> postElements = $$(("[id^=post-]"));
            for (SelenideElement postElement : postElements) {
                postElement.$(".category").shouldHave(text(String.valueOf(category)));
            }
        });
    }


    @ParameterizedTest(name = "For tag {0} on website blog.stratio.com visible only articles that have tag {0}")
    @EnumSource(Tags.class)
    @Tag("parametrized")
    void testFilterArticlesByTags(Tags tag) {
        step("Opening the blog.stratio.com page", () -> {
            open(mainPage + "blog");
        });

        step("Clicking on tag", () -> {
            $(".tagcloud").$(byText(tag.displayName())).scrollTo().click(); // click tag
        });

        step("Check if the title is correct: {0}", () -> {
            $(".archive-head .title").shouldHave(text(tag.displayName())); // check title
        });

        step("Opening the first article in the list by tag {0}", () -> {
            $(".post-title-alt").scrollTo().click();

        });

        step("Checking if the tag {0} are located under the first article", () -> {
//            List<SelenideElement> postElements = $$(("[id^=post-]"));
//            for (SelenideElement postElement : postElements) {
            $(".the-post .post-tags").shouldHave(text(tag.displayName()));
//            }
        });

    }
}
