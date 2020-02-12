package web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.rogzy.api.config.Cfg;
import ru.rogzy.api.core.annotations.Web;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@Web
public class WebTests {

    @Inject
    Cfg cfg;

    @Test
    @DisplayName("Подменю Who We Serve")
    @Description("detected bug")
    void checkItemsSubMenu() {
        open(cfg.webUrl());

        closeAnnoyingWindow();
        hoverSubMenu();
        ElementsCollection actual = $$(By.xpath("//a[contains(text(),'WHO WE SERVE')]/parent::*/div/ul/li/a"));

        CollectionCondition expected = CollectionCondition.exactTexts(Arrays.asList(
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
        open(cfg.webUrl());
        closeAnnoyingWindow();

        $(By.xpath("//input[@type='search']")).setValue(cfg.textForSearch());
        $$(By.xpath("//aside[contains(@class, 'ui-widget')]/section/div/*")).first().isDisplayed();
    }

    @Test
    @DisplayName("Search functionality")
    void checkResultSearch() {
        open(cfg.webUrl());
        closeAnnoyingWindow();

        $(By.xpath("//input[@type='search']")).setValue(cfg.textForSearch()).pressEnter();

        assertThat(title()).contains(cfg.textForSearch());
    }

    @Step
    private void closeAnnoyingWindow() {
        $(By.xpath("//form[@class='country-location-form']//button[@class='close']")).click();
    }

    @Step
    private void hoverSubMenu() {
        $(By.xpath("//a[contains(text(),'WHO WE SERVE')]")).hover();
    }


}
