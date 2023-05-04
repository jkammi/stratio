package com.stratio.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Interactable;
import com.stratio.TestBase;
import com.stratio.data.Tags;
import org.aspectj.apache.bcel.classfile.Utility;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Disabled
    @DisplayName("Search on the blog page")
    @Tag("search")
    @ParameterizedTest(name = "Tag: {0}")
    @EnumSource(Tags.class)
    void SearchTest(Tags tag) {
        step("Opening the blog page", () -> {
            open(mainPage + "blog");
        });

        step("Clicking Search button", () -> {
            $(".fa-search").click();
        });

        step("Enter the search request", () -> {
            $(".search-field").setValue(tag.displayName()).pressEnter();
        });

        step("Check if the search request exists in the articles", () -> {
            ElementsCollection posts = $$(".post-title-alt a").shouldHave(CollectionCondition.sizeGreaterThan(0));
            Iterator<SelenideElement> postsIterator = posts.asDynamicIterable().iterator();

            while (postsIterator.hasNext() ) {
                SelenideElement post = postsIterator.next();
                post.should(exist);
                post.scrollTo();
                post.shouldBe(interactable);
                post.click();
                $(".post-template-default").shouldHave(text(tag.displayName()));
                back();
                ElementsCollection checkPosts = $$(".post-title-alt a").shouldHave(CollectionCondition.sizeGreaterThan(0));
                checkPosts.first().shouldBe(interactable);
            }
        });
    }
}
