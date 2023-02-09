package ru.yandex.practicum.diplom3.web;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.diplom3.GenerateUser;
import ru.yandex.practicum.diplom3.pages.HomePage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;
import static ru.yandex.practicum.diplom3.web.BrowserType.YANDEX_BROWSER;

public class LoginTest extends BaseTest {

    private static final String LK_BUTTON = "lkButton";
    private static final String SIGN_IN_BUTTON = "signInButton";

    @Before
    public void setUP() throws IOException {
        initBrowser(YANDEX_BROWSER);
        createUser();
    }

    @Test
    public void checkLoginRegisteredUser() {
        assertTrue(open(BASE_URL, HomePage.class)
                .openLoginPage(SIGN_IN_BUTTON)
                .openRegisterPage()
                .registrationUserValidData(user)
                .signIn(user)
                .openProfilePage()
                .isProfilePage());
    }

    @Test
    public void checkLoginRegisteredUserHardCore() {
        assertTrue(open(BASE_URL, HomePage.class)
                .openLoginPage(SIGN_IN_BUTTON)
                .openRegisterPage()
                .registrationUserHardCore("user0000", "user0000@gmail.com", "password")
                .signInHardCore("user0000@gmail.com", "password")
                .openProfilePage()
                .isProfilePage());
    }

}