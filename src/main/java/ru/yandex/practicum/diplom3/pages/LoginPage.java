package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage extends AbstractPage {

    private static final String LOGIN_BTN = ".//*[@id='root']/div/main/div/form/button";
    private static final String REGISTER_BTN = ".//*[@id='root']/div/main/div/div/p[1]/a";
    private static final String RESTORE_PASSWORD_BTN = ".//*[@id='root']/div/main/div/div/p[2]/a";
    private static final String FIELD_EMAIL = ".//form/fieldset[1]/div/div/input";
    private static final String FIELD_PASSWORD = ".//form/fieldset[2]/div/div/input";
    private static final String LOGIN_HEADER = ".//h2[contains(text(),'Вход')]";

    @FindBy(how = How.XPATH, using = LOGIN_BTN)
    protected SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = REGISTER_BTN)
    protected SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = RESTORE_PASSWORD_BTN)
    protected SelenideElement restorePasswordButton;

    @FindBy(how = How.XPATH, using = FIELD_EMAIL)
    protected SelenideElement fieldEmail;

    @FindBy(how = How.XPATH, using = FIELD_PASSWORD)
    protected SelenideElement fieldPassword;

    @FindBy(how = How.XPATH, using = LOGIN_HEADER)
    protected SelenideElement loginHeader;

    public RegisterPage openRegisterPage() {
        registerButton.click();

        registerPage = page(RegisterPage.class);
        registerPage.waitForRegisterPage();
        return registerPage;
    }

    public ForgotPasswordPage openRestorePasswordPage() {
        restorePasswordButton.click();

        forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.waitForForgotPasswordPage();
        return forgotPasswordPage;
    }

    protected void clickLoginButton() {
        loginButton.click();
    }

    public String getTextLoginHeader() {
        return loginHeader.getText();
    }

    public void waitForLoginPage() {
        loginHeader.should(visible);
    }

}