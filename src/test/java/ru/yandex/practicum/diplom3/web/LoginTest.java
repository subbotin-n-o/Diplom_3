package ru.yandex.practicum.diplom3.web;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;
import static ru.yandex.practicum.diplom3.web.BrowserType.YANDEX_BROWSER;

public class LoginTest extends BaseTest {

    private static final String LK_BUTTON = "lkButton";
    private static final String SIGN_IN_BUTTON = "signInButton";

    @Before
    public void setUP() throws IOException {
        initBrowser(GOOGLE_CHROME);
        createUser();
    }

    @Test
    public void checkLoginRegisteredUser() {
        assertTrue(openHomePage()
                .openLoginPage(SIGN_IN_BUTTON)
                .openRegisterPage()
                .registrationUserValidData(user)
                .signIn(user)
                .isRegisteredUserHomePage());
    }

}