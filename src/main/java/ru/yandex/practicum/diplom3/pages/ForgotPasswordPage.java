package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    private static final String RESTORE_PASSWORD_HEADER = ".Auth_login__3hAey > h2";
    private static final String LOGIN_BTN = "Войти";

    @FindBy(how = How.CSS, using = RESTORE_PASSWORD_HEADER)
    private SelenideElement forgotPasswordHeader;

    @FindBy(how = How.LINK_TEXT, using = LOGIN_BTN)
    private SelenideElement loginButton;

    public LoginPage openLoginPage() {
        loginButton.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();
        return loginPage;
    }

    public void waitForForgotPasswordPage(){
        forgotPasswordHeader.should(visible);
    }
}