package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.practicum.diplom3.GenerateUser;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage extends AbstractPage {

    public static final String FIELD_NAME = ".//form/fieldset[1]/div/div/input";
    public static final String FIELD_EMAIL = ".//form/fieldset[2]/div/div/input";
    public static final String FIELD_PASSWORD = "Пароль";
    public static final String REGISTER_BTN = "Зарегистрироваться";
    public static final String LOGIN_BTN = "Войти";
    public static final String ERROR_MESSAGE = ".input__error";
    public static final String REGISTER_HEADER = ".Auth_login__3hAey > h2:nth-child(1)";

    @FindBy(how = How.XPATH, using = FIELD_NAME)
    private SelenideElement fieldName;

    @FindBy(how = How.XPATH, using = FIELD_EMAIL)
    private SelenideElement fieldEmail;

    @FindBy(how = How.NAME, using = FIELD_PASSWORD)
    private SelenideElement fieldPassword;

    @FindBy(how = How.LINK_TEXT, using = REGISTER_BTN)
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = LOGIN_BTN)
    private SelenideElement loginButton;

    @FindBy(how = How.CSS, using = ERROR_MESSAGE)
    private SelenideElement errorMessage;

    @FindBy(how = How.CSS, using = REGISTER_HEADER)
    private SelenideElement registerHeader;

    public RegisteredUserLoginPage registrationUserValidDataHARD(GenerateUser user) {
        setFieldName(user.getName());
        setFieldEmail(user.getEmail());
        setFieldPassword(user.getValidPassword());
        clickLoginButton();

        registeredUserLoginPage = page(RegisteredUserLoginPage.class);
        registeredUserLoginPage.waitForRegisteredUserLoginPage();

        return registeredUserLoginPage;
    }

    public RegisteredUserLoginPage registrationUserValidDataHARD(String name, String email, String password) {
        setFieldName(name);
        setFieldEmail(email);
        setFieldPassword(password);
        clickLoginButton();

        registeredUserLoginPage = page(RegisteredUserLoginPage.class);
        registeredUserLoginPage.waitForRegisteredUserLoginPage();

        return registeredUserLoginPage;
    }

    public RegisterPage registrationUserNotValidData(String name, String email, String password) {
        setFieldName(name);
        setFieldEmail(email);
        setFieldPassword(password);
        clickLoginButton();

        loginPage = page(LoginPage.class);
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