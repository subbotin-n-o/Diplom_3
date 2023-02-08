package ru.yandex.practicum.diplom3.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.diplom3.pages.HomePage;
import ru.yandex.practicum.diplom3.pages.LoginPage;
import ru.yandex.practicum.diplom3.pages.RegisterPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.diplom3.pages.RegisterPage.*;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;

public class LoginTest extends BaseTest {

    public static final String LK_BUTTON = "lkButton";
    public static final String SIGN_IN_BUTTON = "signInButton";

//    private BrowserType browserType;

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUP() throws IOException {
        initBrowser(GOOGLE_CHROME);
    }

    @Test
    public void checkLoginRegisteredUser() {

        assertTrue(open(BASE_URL, HomePage.class)
                .openLoginPage(LK_BUTTON)
                .openRegisterPage()
                .validLogin()
                .signIn(NAME, VALID_PASSWORD)
                .openProfilePage()
                .isProfilePage());
    }
}