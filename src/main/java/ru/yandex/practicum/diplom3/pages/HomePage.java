package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    private static final String LK_BTN = ".//header/nav/a/p";
    private static final String SIGN_IN_BTN = ".//section[2]/div/button";
    private static final String HEADER = "active";

    @FindBy(how = How.XPATH, using = LK_BTN)
    private SelenideElement lkButton;

    @FindBy(how = How.XPATH, using = SIGN_IN_BTN)
    private SelenideElement signInButton;

    @FindBy(how = How.CLASS_NAME, using = HEADER)
    private SelenideElement header;

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

    public void waitForHomePage() {
        header.should(visible);
    }
}