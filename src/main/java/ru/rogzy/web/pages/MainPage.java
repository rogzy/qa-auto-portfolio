package ru.rogzy.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage implements AbstractPage {

    public MainPage() {
        closePopUpWindow();
    }

    public SelenideElement hoverSubMenu(String subMenuName) {
        return getSubMenu(subMenuName).hover();
    }

    public void hoverSectionInSubMenu(String subMenuName, String sectionName) {
        hoverSubMenu(subMenuName);
        SelenideElement element = getSection(sectionName);
        element.waitUntil(Condition.visible, 5000, 500).hover();
    }

    public ElementsCollection getSubMenuList(String subMenuName) {
        return getSubMenu(subMenuName).findAll(By.xpath("./parent::*/div/ul/li/a"));
    }

    public ElementsCollection getSectionList(String sectionName) {
        return getSection(sectionName).findAll(By.xpath("./following-sibling::*//a"));
    }

    public SelenideElement textInput(String textForSearch) {
        return $(By.xpath("//input[@type='search']")).setValue(textForSearch);
    }

    public SearchResultPage textInputAndGoToResult(String textForSearch) {
        $(By.xpath("//input[@type='search']")).setValue(textForSearch).pressEnter();
        return page(SearchResultPage.class);
    }

    public SelenideElement getPreviewSearchResult() {
        return $$(By.xpath("//aside[contains(@class, 'ui-widget')]/section/div/*")).first();
    }

    private SelenideElement getSubMenu(String subMenuName) {
        return $(By.xpath("//a[contains(text(),'" + subMenuName.toUpperCase() + "')]"));
    }

    private SelenideElement getSection(String sectionName) {
        return $(By.xpath("//ul//*[contains(text(),'" + sectionName + "')]"));
    }
}
