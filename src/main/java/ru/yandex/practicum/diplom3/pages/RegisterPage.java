package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static ru.yandex.practicum.diplom3.GenerateRandomData.*;
import static ru.yandex.practicum.diplom3.GenerateRandomData.getRandomNotValidPassword;

public class RegisterPage {

    public static final String FIELD_NAME = ".//form/fieldset[1]/div/div/input";
    public static final String FIELD_EMAIL = ".//form/fieldset[2]/div/div/input";
    public static final String PASSWORD = "Пароль";
    public static final String REGISTER = "Зарегистрироваться";
    public static final String LOGIN = "Войти";
    public static final String ERROR_MESSAGE = ".input__error";
    public static final String REGISTER_HEADER = ".Auth_login__3hAey > h2:nth-child(1)";

    public static final String NAME = getRandomName();
    public static final String EMAIL = getRandomEmail();
    public static final String VALID_PASSWORD = getRandomValidPassword();
    public static final String NOT_VALID_PASSWORD = getRandomNotValidPassword();

    @FindBy(how = How.XPATH, using = FIELD_NAME)
    private SelenideElement fieldName;

    @FindBy(how = How.XPATH, using = FIELD_EMAIL)
    private SelenideElement fieldEmail;

    @FindBy(how = How.NAME, using = PASSWORD)
    private SelenideElement fieldPassword;

    @FindBy(how = How.LINK_TEXT, using = REGISTER)
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = LOGIN)
    private SelenideElement loginButton;

    @FindBy(how = How.CSS, using = ERROR_MESSAGE)
    private SelenideElement errorMessage;

    @FindBy(how = How.CSS, using = REGISTER_HEADER)
    private SelenideElement registerHeader;

    public LoginPage validLogin() {
        setFieldName(NAME);
        setFieldEmail(EMAIL);
        setFieldPassword(VALID_PASSWORD);
        clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();

        return loginPage;
    }

    public RegisterPage notValidLogin() {
        setFieldName(NAME);
        setFieldEmail(EMAIL);
        setFieldPassword(NOT_VALID_PASSWORD);
        clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();

        return this;
    }

    private void setFieldName(String name) {
        fieldName.setValue(name);
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

    public String getTextErrorMessage() {
        waitForErrorMessage();
        return errorMessage.getText();
    }

    public void waitForRegisterPage() {
        registerHeader.should(visible);
    }

    private void waitForErrorMessage() {
        errorMessage.should(visible);
    }
}