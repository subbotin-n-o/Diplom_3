package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.practicum.diplom3.GenerateUser;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage extends AbstractPage {

    public static final String FIELD_NAME = ".//form/fieldset[1]/div/div/input";
    public static final String FIELD_EMAIL = ".//form/fieldset[2]/div/div/input";
    public static final String FIELD_PASSWORD = ".//form/fieldset[3]/div/div/input";
    public static final String REGISTER_BTN = ".//*[@id='root']/div/main/div/form/button";
    public static final String LOGIN_BTN = ".//*[@id='root']/div/main/div/div/p/a";
    public static final String ERROR_MESSAGE = ".input__error";
    public static final String REGISTER_HEADER = ".//h2[contains(text(),'Регистрация')]";

    @FindBy(how = How.XPATH, using = FIELD_NAME)
    private SelenideElement fieldName;

    @FindBy(how = How.XPATH, using = FIELD_EMAIL)
    private SelenideElement fieldEmail;

    @FindBy(how = How.XPATH, using = FIELD_PASSWORD)
    private SelenideElement fieldPassword;

    @FindBy(how = How.XPATH, using = REGISTER_BTN)
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = LOGIN_BTN)
    private SelenideElement loginButton;

    @FindBy(how = How.CSS, using = ERROR_MESSAGE)
    private SelenideElement errorMessage;

    @FindBy(how = How.XPATH, using = REGISTER_HEADER)
    private SelenideElement registerHeader;

    public RegisteredUserLoginPage registrationUserValidData(GenerateUser user) {
        setFieldName(user.getName());
        setFieldEmail(user.getEmail());
        setFieldPassword(user.getValidPassword());
        clickRegisterButton();

        registeredUserLoginPage = page(RegisteredUserLoginPage.class);
        registeredUserLoginPage.waitForRegisteredUserLoginPage();

        return registeredUserLoginPage;
    }

    public RegisterPage registrationUserNotValidData(GenerateUser user) {
        setFieldName(user.getName());
        setFieldEmail(user.getEmail());
        setFieldPassword(user.getNotValidPassword());
        clickRegisterButton();

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

    private void clickRegisterButton() {
        registerButton.shouldBe(enabled, Duration.ofSeconds(8)).click();
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