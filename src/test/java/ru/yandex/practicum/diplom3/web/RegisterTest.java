package ru.yandex.practicum.diplom3.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.diplom3.pages.HomePage;
import ru.yandex.practicum.diplom3.pages.LoginPage;
import ru.yandex.practicum.diplom3.pages.RegisterPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;
import static ru.yandex.practicum.diplom3.web.BrowserType.YANDEX_BROWSER;

@RunWith(Parameterized.class)
public class RegisterTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    private final String buttonChoice;
    private final BrowserType browserType;

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public static final String LK_BUTTON = "lkButton";
    public static final String SIGN_IN_BUTTON = "signInButton";

    public static final String LOGIN = "Вход";
    public static final String INCORRECT_PASSWORD = "Некорректный пароль";

    public RegisterTest(String buttonChoice, BrowserType browserType) {
        this.buttonChoice = buttonChoice;
        this.browserType = browserType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {LK_BUTTON, GOOGLE_CHROME},
                {SIGN_IN_BUTTON, GOOGLE_CHROME},
                {LK_BUTTON, YANDEX_BROWSER},
                {SIGN_IN_BUTTON, YANDEX_BROWSER}
        };
    }

    @Before
    public void setUP() throws IOException {
        initBrowser(browserType);

        openHomePage();
        openLoginPage();
        openRegisterPage();
    }

    @Test
    public void checkRegisterValidPassword() {
        String actualTextLoginHeader = registerPage
                .validLogin()
                .getTextLoginHeader();

        assertEquals(LOGIN, actualTextLoginHeader);
    }

    @Test
    public void checkRegisterNotValidPassword() {
        String actualErrorMessage = registerPage
                .notValidLogin()
                .getTextErrorMessage();

        assertEquals(INCORRECT_PASSWORD, actualErrorMessage);
    }

    private void openRegisterPage() {
        registerPage =
                loginPage.openRegisterPage();
    }

    private void openLoginPage() {
        loginPage =
                homePage.openLoginPage(buttonChoice);
    }

    private void openHomePage() {
        homePage =
                open(BASE_URL, HomePage.class);
    }

    @After
    public void tearDown() {
        browserClose();
    }

}