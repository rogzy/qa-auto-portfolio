package ru.rogzy.web.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage implements AbstractPage {

    public SearchResultPage() {
        closePopUpWindow();
    }

    public ElementsCollection getProductTitles() {
        return $$(By.xpath("//div[@class='products-list']/section//h3//span"));
    }
}
