package ru.yandex.practicum.diplom3.pages;

import ru.yandex.practicum.diplom3.GenerateUser;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class RegisteredUserLoginPage extends LoginPage {

    public RegisteredUserHomePage signInHardCore(String email, String password) {
        setFieldEmail(email);
        setFieldPassword(password);
        clickLoginButton();

        registeredUserHomePage = page(RegisteredUserHomePage.class);
        registeredUserHomePage.waitForRegisteredUserHomePage();
        return registeredUserHomePage;
    }

    public RegisteredUserHomePage signIn(GenerateUser user) {
        setFieldEmail(user.getEmail());
        setFieldPassword(user.getValidPassword());
        clickLoginButton();

        registeredUserHomePage = page(RegisteredUserHomePage.class);
        registeredUserHomePage.waitForRegisteredUserHomePage();
        return registeredUserHomePage;
    }

    private void setFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    private void setFieldPassword(String password) {
        fieldPassword.setValue(password);
    }

    private void clickLoginButton() {
        loginButton.shouldBe(enabled).click();
    }

    public void waitForRegisteredUserLoginPage() {
        loginHeader.should(visible);
    }

}