package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    private SelenideElement restorePasswordButton;

    @FindBy(how = How.CSS, using = ".Auth_login__3hAey > h2")
    private SelenideElement loginHeader;

    public RegisterPage clickRegisterButton() {
        registerButton.click();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.waitForRegisterPage();
        return registerPage;
    }

    public ForgotPasswordPage clickRestorePasswordButton() {
        restorePasswordButton.click();

        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.waitForForgotPasswordPage();
        return forgotPasswordPage;
    }

    public String getTextLoginHeader() {
        return loginHeader.getText();
    }

    public void waitForLoginPage(){
        loginHeader.should(visible);
    }
}