package web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.rogzy.api.config.Cfg;
import ru.rogzy.api.core.annotations.Web;

import java.util.Arrays;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

@Web
public class WebTests {

    @Inject
    Cfg cfg;

    @BeforeEach
    void before() {
        init();
    }

    @Test
    @DisplayName("Подменю Who We Serve")
    @Description("detected bug")
    void checkItemsSubMenu() {
        hoverSubMenu("Who we serve");
        ElementsCollection actual = $$(By.xpath("//a[contains(text(),'WHO WE SERVE')]/parent::*/div/ul/li/a"));

        CollectionCondition expected = exactTexts(Arrays.asList(
                "Students",
                "Instructors",
                "Book Authors",
                "Professionals",
                "Researchers",
                "Institutions",
                "Librarians",
                "Corporations",
                "Societies",
                "Journal Editors",
                "Government"));
        actual.shouldHave(expected);
    }

    @Test
    @DisplayName("Отображение превью")
    void checkSearchPreview() {
        $(By.xpath("//input[@type='search']")).setValue(cfg.textForSearch());
        $$(By.xpath("//aside[contains(@class, 'ui-widget')]/section/div/*")).first().isDisplayed();
    }

    @Test
    @DisplayName("Search functionality")
    void checkResultSearch() {
        $(By.xpath("//input[@type='search']")).setValue(cfg.textForSearch()).pressEnter();

        closeAnnoyingWindow();

        ElementsCollection products = $$(By.xpath("//div[@class='products-list']/section"));

        products.iterator().forEachRemaining(el -> el.$(By.xpath(".//h3//span")).shouldHave(Condition.matchText("Java")));
    }

    @Test
    @Tag("qa")
    @DisplayName("Subjects in Education")
    void checkItemsSectionEducation() {
        hoverSubMenu("SUBJECTS");

        hoverSectionMenu();

        ElementsCollection actual = $$(By.xpath("//ul//*[contains(text(),'Education')]/following-sibling::*//a"));

        CollectionCondition expected = exactTexts(Arrays.asList(
                "Assessment, Evaluation Methods",
                "Classroom Management",
                "Conflict Resolution & Mediation",
                "Curriculum Tools",
                "Education & Public Policy",
                "Educational Research",
                "General Education",
                "Higher Education",
                "Information & Library Science",
                "Special Education",
                "Special Topics",
                "Vocational Technology"));

        actual.shouldHave(expected);
    }

    @Step
    private void closeAnnoyingWindow() {
        $(By.xpath("//form[@class='country-location-form']//button[@class='close']")).click();
    }

    @Step
    private SelenideElement hoverSubMenu(String name) {
        return $(By.xpath("//a[contains(text(),'" + name.toUpperCase() + "')]")).hover();
    }

    @Step
    private void hoverSectionMenu() {
        hoverSubMenu("Subjects");
        SelenideElement element = $(By.xpath("//ul//*[contains(text(),'Education')]"));
        element.waitUntil(Condition.visible, 5000, 500).hover();
    }

    @Step
    private void init() {
        open(cfg.webUrl());
        closeAnnoyingWindow();
    }

}
