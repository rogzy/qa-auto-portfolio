package web;

import com.codeborne.selenide.*;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import ru.rogzy.api.core.annotations.web.Education;
import ru.rogzy.api.core.annotations.web.Web;
import ru.rogzy.api.core.annotations.web.WhoWeServe;
import ru.rogzy.web.config.WebCfg;

import static com.codeborne.selenide.Selenide.*;

@Web
@FieldDefaults(level = AccessLevel.PRIVATE)
class WebTests {

    final String WHO_WE_SERVE = "Who we serve";
    final String SUBJECTS = "Subjects";
    final String EDUCATION = "Education";

    @Inject
    WebCfg cfg;

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void before() {
        init();
    }

    @AfterEach
    void after() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Состав подменю 'Who We Serve'")
    @Description("detected bug")
    void checkItemsSubMenu(@WhoWeServe CollectionCondition expected) {
        By subMenuList = By.xpath("./parent::*/div/ul/li/a");
        hoverSubMenu(WHO_WE_SERVE);
        ElementsCollection actual = getSubMenu(WHO_WE_SERVE).findAll(subMenuList);
        actual.shouldHave(expected);
    }

    @Test
    @DisplayName("Отображение превью после ввода текста")
    void checkSearchPreview() {
        textInput();
        $$(By.xpath("//aside[contains(@class, 'ui-widget')]/section/div/*")).first().isDisplayed();
    }

    @Test
    @DisplayName("Заголовки найденых продуктов содержат поисковую фразу")
    void checkResultSearch() {
        By titleProduct = By.xpath(".//h3//span");
        textInput().pressEnter();
        closePopUpWindow();
        ElementsCollection products = $$(By.xpath("//div[@class='products-list']/section"));
        products.iterator().forEachRemaining(el -> el.$(titleProduct).shouldHave(Condition.matchText(cfg.textForSearch())));
    }

    @Test
    @DisplayName("Состав секции 'Education'")
    void checkItemsSectionEducation(@Education CollectionCondition expected) {
        By sectionList = By.xpath("./following-sibling::*//a");
        hoverSubMenu(SUBJECTS);
        hoverSectionInSubMenu(SUBJECTS, EDUCATION);
        ElementsCollection actual = getSection(EDUCATION).findAll(sectionList);
        actual.shouldHave(expected);
    }

    @Step
    private void init() {
        open(cfg.webUrl());
        closePopUpWindow();
    }

    @Step
    private void closePopUpWindow() {
        $(By.xpath("//form[@class='country-location-form']//button[@class='close']")).click();
    }

    @Step
    private SelenideElement textInput() {
        return $(By.xpath("//input[@type='search']")).setValue(cfg.textForSearch());
    }

    @Step
    private SelenideElement hoverSubMenu(String subMenuName) {
        return getSubMenu(subMenuName).hover();
    }

    @Step
    private void hoverSectionInSubMenu(String subMenuName, String sectionName) {
        hoverSubMenu(subMenuName);
        SelenideElement element = getSection(sectionName);
        element.waitUntil(Condition.visible, 5000, 500).hover();
    }

    private SelenideElement getSubMenu(String subMenuName) {
        return $(By.xpath("//a[contains(text(),'" + subMenuName.toUpperCase() + "')]"));
    }

    private SelenideElement getSection(String sectionName) {
        return $(By.xpath("//ul//*[contains(text(),'" + sectionName + "')]"));
    }

}
