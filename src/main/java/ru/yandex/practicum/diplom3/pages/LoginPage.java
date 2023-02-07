package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    private static final String LOGIN_BTN = ".button_button__33qZ0";
    private static final String REGISTER_BTN = "Зарегистрироваться";
    private static final String RESTORE_PASSWORD_BTN = "Восстановить пароль";
    private static final String FIELD_EMAIL = ".//form/fieldset[1]/div/div/input";
    private static final String FIELD_PASSWORD = ".//form/fieldset[2]/div/div/input";
    private static final String LOGIN_HEADER = ".Auth_login__3hAey > h2";

    @FindBy(how = How.CSS, using = LOGIN_BTN)
    private SelenideElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = REGISTER_BTN)
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = RESTORE_PASSWORD_BTN)
    private SelenideElement restorePasswordButton;

    @FindBy(how = How.XPATH, using = FIELD_EMAIL)
    private SelenideElement fieldEmail;

    @FindBy(how = How.XPATH, using = FIELD_PASSWORD)
    private SelenideElement fieldPassword;

    @FindBy(how = How.CSS, using = LOGIN_HEADER)
    private SelenideElement loginHeader;

    public HomePage signIn(String email, String password) {
        setFieldEmail(email);
        setFieldPassword(password);
        clickLoginButton();

        HomePage homePage = page(HomePage.class);
        homePage.waitForHomePage();
        return homePage;
    }

    public RegisterPage openRegisterPage() {
        registerButton.click();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.waitForRegisterPage();
        return registerPage;
    }

    public ForgotPasswordPage openRestorePasswordPage() {
        restorePasswordButton.click();

        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.waitForForgotPasswordPage();
        return forgotPasswordPage;
    }

    private void setFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    private void setFieldPassword(String password) {
        fieldPassword.setValue(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public String getTextLoginHeader() {
        return loginHeader.getText();
    }

    public void waitForLoginPage() {
        loginHeader.should(visible);
    }

}