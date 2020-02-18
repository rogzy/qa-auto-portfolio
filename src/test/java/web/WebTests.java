package web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.inject.Inject;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.*;
import ru.rogzy.api.core.annotations.web.Education;
import ru.rogzy.api.core.annotations.web.Web;
import ru.rogzy.api.core.annotations.web.WhoWeServe;
import ru.rogzy.web.config.WebCfg;
import ru.rogzy.web.pages.MainPage;
import ru.rogzy.web.pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("Wiley")
@Web
@Owner("Александр")
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
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @Feature("Отображение подменю")
    @Story("Состав подменю")
    @DisplayName("Состав подменю 'Who We Serve'")
    @Description(value = "id detected bug")
    void checkItemsSubMenu(@WhoWeServe CollectionCondition expected) {
        MainPage mainPage = open(cfg.webUrl(), MainPage.class);
        mainPage.hoverSubMenu(WHO_WE_SERVE);
        ElementsCollection actual = mainPage.getSubMenuList(WHO_WE_SERVE);
        actual.shouldHave(expected);
    }

    @Test
    @Feature("Поиск")
    @Story("Отображение превью")
    @DisplayName("Отображение превью после ввода текста")
    void checkSearchPreview() {
        MainPage mainPage = open(cfg.webUrl(), MainPage.class);
        mainPage.textInput(cfg.textForSearch());
        mainPage.getPreviewSearchResult().shouldBe(Condition.visible);
    }

    @Test
    @Feature("Поиск")
    @Story("Отображение страницы резульата")
    @DisplayName("Заголовки найденых продуктов содержат поисковую фразу")
    void checkResultSearch() {
        MainPage mainPage = open(cfg.webUrl(), MainPage.class);
        SearchResultPage searchResultPage = mainPage.textInputAndGoToResult(cfg.textForSearch());
        ElementsCollection products = searchResultPage.getProductTitles();
        products.iterator().forEachRemaining(el -> el.shouldHave(Condition.matchText(cfg.textForSearch())));
    }

    @Test
    @Feature("Отображение подменю")
    @Story("Состав секции")
    @DisplayName("Состав секции 'Education'")
    void checkItemsSectionEducation(@Education CollectionCondition expected) {
        MainPage mainPage = open(cfg.webUrl(), MainPage.class);
        mainPage.hoverSubMenu(SUBJECTS);
        mainPage.hoverSectionInSubMenu(SUBJECTS, EDUCATION);
        ElementsCollection actual = mainPage.getSectionList(EDUCATION);
        actual.shouldHave(expected);
    }
}
