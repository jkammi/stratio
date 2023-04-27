package com.stratio;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.stratio.data.Categories;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.fail;

public class Simple_tests extends TestBase {

    private static final String HOME_TITLE = "Augmented Data Fabric";
    private static final String PRODUCT_TITLE = "One single product for automated AI Data management";
    String homePage = "https://www.stratio.com/home";

    @Test
    @Tag("simple")
    @DisplayName("The title on a /home page is correct")
    void simpleTest() {
        step("Opening the main page", () -> {
            open(homePage);
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
            open(homePage);
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
    @DisplayName("Blog")
    void testCategoriesExistOnWebsite(Categories category)  {
            step("Opening the main page", () -> {
                open(homePage);
            });

            step("Click on the Blog", () -> {
                $("a[href='http://blog.stratio.com']").click();
                switchTo().window(1);
            });
//            sleep(100000);

            step("Choosing the category", () -> {
                $("#cat.postform").click(); // click on the category button
                $("option").$(byText(String.valueOf(category))).click(); // select category from a dropdown
//                $("option").selectOption(String.valueOf(category)); // another option // Cannot select option from a non-select element
            });
//
//        step("Checking that only articles with the selected category are visible", () -> {
//            $$(".article").forEach(article -> {
//                if (!article.find(".categories").text().contains(String.valueOf(category))) {
//                    fail("Article with wrong category found");
//                }
//            });
//        });

    }

}
