package ru.yandex.practicum.diplom3.pages;

import static com.codeborne.selenide.Selenide.page;

public class RegisteredUserLoginPage extends LoginPage {

    public RegisteredUserHomePage signIn(String email, String password) {
        setFieldEmail(email);
        setFieldPassword(password);
        clickLoginButton();

        registeredUserHomePage = page(RegisteredUserHomePage.class);
        registeredUserHomePage.waitForRegisteredUserHomePage();
        return registeredUserHomePage;
    }

    public RegisteredUserHomePage signInHard() {
        setFieldEmail("nestor.dare@gmail.com");
        setFieldPassword("6tpv1t");
        clickLoginButton();

        registeredUserHomePage = page(RegisteredUserHomePage.class);
        registeredUserHomePage.waitForHomePage();
        return registeredUserHomePage;
    }

    private void setFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    private void setFieldPassword(String password) {
        fieldPassword.setValue(password);
    }


}