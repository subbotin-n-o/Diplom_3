package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    public static final String FIELD_NAME = ".//form/fieldset[1]/div/div/input";
    public static final String FIELD_EMAIL = ".//form/fieldset[2]/div/div/input";
    public static final String PASSWORD = "Пароль";
    public static final String REGISTER = "Зарегистрироваться";
    public static final String LOGIN = "Войти";
    public static final String ERROR_MESSAGE = ".input__error";

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

    public LoginPage login(String name, String email, String password) {
        setFieldName(name);
        setFieldEmail(email);
        setFieldPassword(password);
        clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();

        return loginPage;
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
        $(byText("Регистрация")).should(visible);
    }

    private void waitForErrorMessage() {
        errorMessage.should(visible);
    }
}