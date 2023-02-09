package ru.yandex.practicum.diplom3.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.diplom3.pages.HomePage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;
import static ru.yandex.practicum.diplom3.web.BrowserType.YANDEX_BROWSER;

@RunWith(Parameterized.class)
public class RegisterTest extends BaseTest {

    private final String buttonChoice;
    private final BrowserType browserType;

    private static final String LK_BUTTON = "lkButton";
    private static final String SIGN_IN_BUTTON = "signInButton";

    private static final String LOGIN = "Вход";
    private static final String INCORRECT_PASSWORD = "Некорректный пароль";

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
        createUser();
    }

    @Test
    public void checkRegisterValidPassword() {

        assertEquals(LOGIN, open(BASE_URL, HomePage.class)
                .openLoginPage(buttonChoice)
                .openRegisterPage()
                .registrationUserValidData(user)
                .getTextLoginHeader());
    }

    @Test
    public void checkRegisterNotValidPassword() {
        assertEquals(INCORRECT_PASSWORD, open(BASE_URL, HomePage.class)
                .openLoginPage(buttonChoice)
                .openRegisterPage()
                .registrationUserNotValidData(user)
                .getTextErrorMessage());
    }

    @After
    public void tearDown() {
        browserClose();
    }

}