package ru.yandex.practicum.diplom3.web;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.diplom3.helpers.UserGenerator;
import ru.yandex.practicum.diplom3.pages.HomePage;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;
import static ru.yandex.practicum.diplom3.web.BrowserType.YANDEX_BROWSER;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    private static final String LK_BUTTON = "lkButton";
    private static final String SIGN_IN_BUTTON = "signInButton";

    public LoginTest(BrowserType browserType) {
        this.browserType = browserType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {GOOGLE_CHROME},
                {YANDEX_BROWSER}
        };
    }

    @Before
    public void setUP() throws IOException {
        initBrowser(browserType);
        createUser();
    }

    @Test
    @DisplayName("Check login using the \"Private Office\" button")
    @Description("Check login User using the \"Private Office\" button on the home page")
    public void a_checkLoginUser() {
        assertTrue(registrationUser(user)
                .openLoginPage(LK_BUTTON)
                .signIn(user)
                .isAuthorizedUserHomePage());
    }

    @Test
    @DisplayName("Check login using the \"Login to account\" button")
    @Description("Check login User using the \"Login to account\" button on the home page")
    public void b_checkLoginUser() {
        assertTrue(registrationUser(user)
                .openLoginPage(SIGN_IN_BUTTON)
                .signIn(user)
                .isAuthorizedUserHomePage());
    }

    @Test
    @DisplayName("Check login using the \"Login\" button")
    @Description("Check login User using the \"Login\" button on the register page")
    public void c_checkLoginUser() {
        assertTrue(registrationUser(user)
                .openLoginPage(LK_BUTTON)
                .openRegisterPage()
                .openLoginPage()
                .signIn(user)
                .isAuthorizedUserHomePage());
    }

    @Test
    @DisplayName("Check login using the \"Restore password\" button")
    @Description("Check login User using the \"Restore password\" button on the restore password page")
    public void d_checkLoginUser() {
        assertTrue(registrationUser(user)
                .openLoginPage(LK_BUTTON)
                .openRestorePasswordPage()
                .openLoginPage()
                .signIn(user)
                .isAuthorizedUserHomePage());
    }

    private HomePage registrationUser(UserGenerator user) {
        return openHomePage()
                .openLoginPage(SIGN_IN_BUTTON)
                .openRegisterPage()
                .registrationUserValidData(user)
                .backToHomePage();
    }

    @After
    public void tearDown() {
        browserClose();
    }

}