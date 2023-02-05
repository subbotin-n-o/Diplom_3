package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = ".//form/fieldset[1]/div/div/input")
    private SelenideElement fieldName;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[2]/div/div/input")
    private SelenideElement fieldEmail;

    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement fieldPassword;

    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButton;

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

    public void waitForRegisterPage() {
        $(byText("Регистрация")).should(visible);
    }
}