package ru.yandex.practicum.diplom3.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.diplom3.pages.HomePage;
import ru.yandex.practicum.diplom3.pages.LoginPage;
import ru.yandex.practicum.diplom3.pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.diplom3.GenerateRandomData.*;

@RunWith(Parameterized.class)
public class RegisterTest {

    private HomePage homePage;
    private LoginPage loginPage;
    RegisterPage registerPage;

    private final String buttonChoice;

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public static final String NAME = getRandomName();
    public static final String EMAIL = getRandomEmail();
    public static final String VALID_PASSWORD = getRandomValidPassword();
    public static final String NOT_VALID_PASSWORD = getRandomNotValidPassword();

    public static final String LK_BUTTON = "lkButton";
    public static final String SIGN_IN_BUTTON = "signInButton";

    public static final String LOGIN = "Вход";
    public static final String INCORRECT_PASSWORD = "Некорректный пароль";

    public RegisterTest(String buttonChoice) {
        this.buttonChoice = buttonChoice;
    }

    @Before
    public void setUP() {
        homePage =
                open(BASE_URL, HomePage.class);
    }

    @Test
    public void checkRegisterValidPassword() {
        loginPage = homePage.openLoginPage(buttonChoice);
        registerPage = loginPage.openRegisterPage();
        loginPage = registerPage.login(NAME, EMAIL, VALID_PASSWORD);

        String actualTextLoginHeader = loginPage.getTextLoginHeader();

        assertEquals(LOGIN, actualTextLoginHeader);
    }

    @Test
    public void checkRegisterNotValidPassword() {
        loginPage = homePage.openLoginPage(buttonChoice);
        registerPage = loginPage.openRegisterPage();
        loginPage = registerPage.login(NAME, EMAIL, NOT_VALID_PASSWORD);

        String actualErrorMessage = registerPage.getTextErrorMessage();

        assertEquals(INCORRECT_PASSWORD, actualErrorMessage);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {LK_BUTTON},
                {SIGN_IN_BUTTON},
        };
    }

}