package ru.yandex.practicum.diplom3.pages;

import ru.yandex.practicum.diplom3.GenerateUser;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegisteredUserLoginPage extends LoginPage {

    public RegisteredUserHomePage signIn(GenerateUser user) {
        setFieldEmail(user.getEmail());
        setFieldPassword(user.getValidPassword());
        clickLoginButton();

        registeredUserHomePage = page(RegisteredUserHomePage.class);
        registeredUserHomePage.waitPage();
        return registeredUserHomePage;
    }

    private void setFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    private void setFieldPassword(String password) {
        fieldPassword.setValue(password);
    }

    @Override
    public void waitPage() {
        loginHeader.should(visible);
    }

}