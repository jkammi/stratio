package com.stratio;

import com.codeborne.selenide.SelenideElement;
import com.stratio.data.Categories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Simple_tests extends TestBase {

    private static final String HOME_TITLE = "Augmented Data Fabric";
    private static final String PRODUCT_TITLE = "One single product for automated AI Data management";
    String mainPage = "https://www.stratio.com/";

    @Test
    @Tag("simple")
    @DisplayName("The title on a /home page is correct")
    void simpleTest() {
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
    void simpleTest2() {
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

    @ParameterizedTest(name = "For category {0} on website blog.stratio.com must be visible only articles with categories {0}")
    @EnumSource(Categories.class)
    @Tag("serious")
    @DisplayName("Filter by categories works correctly")
    void testCategoriesExistOnWebsite(Categories category) {
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
    @EnumSource(Categories.class)
    @DisplayName("On the main blog page there are articles with a different categories")
    @Tag("serious")
    void negativeTestArticlesBlog(Categories category) {
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

}
