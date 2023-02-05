package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement lkButton;

    public LoginPage clickLkButton() {
        lkButton.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();
        return loginPage;
    }
}