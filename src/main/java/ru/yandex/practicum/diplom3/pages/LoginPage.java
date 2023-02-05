package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    public static final String REGISTER = "Зарегистрироваться";
    public static final String RESTORE_PASSWORD = "Восстановить пароль";
    public static final String LOGIN_HEADER = ".Auth_login__3hAey > h2";

    @FindBy(how = How.LINK_TEXT, using = REGISTER)
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = RESTORE_PASSWORD)
    private SelenideElement restorePasswordButton;


    @FindBy(how = How.CSS, using = LOGIN_HEADER)
    private SelenideElement loginHeader;

    public RegisterPage openRegisterPage() {
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

    public void waitForLoginPage() {
        loginHeader.should(visible);
    }

}