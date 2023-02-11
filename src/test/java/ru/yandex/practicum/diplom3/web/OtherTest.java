package ru.yandex.practicum.diplom3.web;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.diplom3.helpers.GenerateUser;
import ru.yandex.practicum.diplom3.pages.AuthorizedUserHomePage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.diplom3.web.BrowserType.GOOGLE_CHROME;

public class OtherTest extends BaseTest {

    private static final String LK_BUTTON = "lkButton";
    private static final String SIGN_IN_BUTTON = "signInButton";

    private static final String LOGIN = "Вход";

    @Before
    public void setUP() throws IOException {
        initBrowser(GOOGLE_CHROME);
        createUser();
    }

    @Test
    @DisplayName("Check transition by clicking on the \"Personal Account\"")
    @Description("Checking the transition by the \"Personal Account\" button from the Home page")
    public void checkTransitionClickLkButton() {
        assertTrue(registrationAndAuthorizationUser(user)
                .openProfilePage()
                .isProfilePage());
    }

    @Test
    @DisplayName("Check the transition by clicking on the \"Constructor\"")
    @Description("Checking the transition by the \"Constructor\" button from the Personal Account page")
    public void checkTransitionByClickConstructorButton() {
        assertTrue(registrationAndAuthorizationUser(user)
                .openProfilePage()
                .TransitionByClickConstructorButton()
                .isAuthorizedUserHomePage());
    }

    @Test
    @DisplayName("Check the transition by clicking on the \"Logo\"")
    @Description("Checking the transition by the \"Stellar Burgers\" button from the Personal Account page")
    public void checkTransitionByClickLogoBurgers() {
        assertTrue(registrationAndAuthorizationUser(user)
                .openProfilePage()
                .TransitionByClickLogoBurgers()
                .isAuthorizedUserHomePage());
    }

    @Test
    @DisplayName("Check Logout")
    @Description("Checking out of your account")
    public void checkLogout() {
        assertEquals(LOGIN, registrationAndAuthorizationUser(user)
                .openProfilePage()
                .logOut()
                .getTextLoginHeader());
    }

    private AuthorizedUserHomePage registrationAndAuthorizationUser(GenerateUser user) {
        return openHomePage()
                .openLoginPage(SIGN_IN_BUTTON)
                .openRegisterPage()
                .registrationUserValidData(user)
                .signIn(user);
    }

    @After
    public void tearDown() {
        browserClose();
    }
}