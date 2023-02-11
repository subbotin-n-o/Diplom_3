package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

abstract public class AbstractPage {
    protected RegisteredUserHomePage registeredUserHomePage;
    protected LoginPage loginPage;
    protected RegisteredUserLoginPage registeredUserLoginPage;
    protected RegisterPage registerPage;
    protected ProfilePage profilePage;
    protected ForgotPasswordPage forgotPasswordPage;

    private static final String LK_BTN = ".//p[contains(text(),'Личный Кабинет')]";

    @FindBy(how = How.XPATH, using = LK_BTN)
    protected SelenideElement lkButton;

    protected void clickLkButton() {
        lkButton.click();
    }

    public void waitPage() {
    }
}