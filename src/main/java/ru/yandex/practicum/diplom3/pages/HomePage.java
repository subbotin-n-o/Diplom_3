package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    public static final String LK_BUTTON = "a.AppHeader_header__link__3D_hX:nth-child(3) > p:nth-child(2)";
    public static final String SIGN_IN_BUTTON = ".button_button__33qZ0";

    @FindBy(how = How.CSS, using = LK_BUTTON)
    private SelenideElement lkButton;

    @FindBy(how = How.CSS, using = SIGN_IN_BUTTON)
    private SelenideElement signInButton;

    public LoginPage openLoginPage(String buttonName) {
        if (buttonName.equals("lkButton")) {
            return clickLkButton();
        } else if (buttonName.equals("signInButton")) {
            return clickSignInButton();
        }
        return null;
    }

    private LoginPage clickLkButton() {
        lkButton.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();
        return loginPage;
    }

    private LoginPage clickSignInButton() {
        signInButton.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoginPage();
        return loginPage;
    }
}