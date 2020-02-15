package ru.rogzy.web.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface AbstractPage {

    default void closePopUpWindow() {
        $(By.xpath("//form[@class='country-location-form']//button[@class='close']")).click();
    }

}
