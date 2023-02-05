package ru.yandex.practicum.diplom3.web;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.diplom3.pages.HomePage;
import ru.yandex.practicum.diplom3.pages.LoginPage;
import ru.yandex.practicum.diplom3.pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.diplom3.GenerateRandomData.*;

public class RegisterTest {

    private HomePage homePage;
    private LoginPage loginPage;
    RegisterPage registerPage;

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public static final String NAME = getRandomName();
    public static final String EMAIL = getRandomEmail();
    public static final String VALID_PASSWORD = getRandomValidPassword();

    public static final String LOGIN = "Вход";

    @Before
    public void setUP() {
        homePage =
                open(BASE_URL, HomePage.class);
    }

    @Test
    public void succesRegisterTest() {
        loginPage = homePage.clickLkButton();
        registerPage = loginPage.clickRegisterButton();
        loginPage = registerPage.login(NAME, EMAIL, VALID_PASSWORD);

        String expectedTextLoginHeader = LOGIN;
        String actualTextLoginHeader = loginPage.getTextLoginHeader();

        assertEquals(expectedTextLoginHeader, actualTextLoginHeader);
    }

}