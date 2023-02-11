package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends AbstractPage {

    private static final String SIGN_IN_BTN = ".//button[contains(text(),'Войти в аккаунт')]";

    @FindBy(how = How.XPATH, using = SIGN_IN_BTN)
    private SelenideElement signInButton;

    public LoginPage openLoginPage(String buttonName) {
        if (buttonName.equals("lkButton")) {
            clickLkButton();

            loginPage = page(LoginPage.class);
            loginPage.waitPage();
            return loginPage;

        } else if (buttonName.equals("signInButton")) {
            clickSignInButton();

            loginPage = page(LoginPage.class);
            loginPage.waitPage();
            return loginPage;
        }
        return null;
    }

    private void clickSignInButton() {
        signInButton.click();
    }

    @Override
    public void waitPage() {
        signInButton.should(visible);
    }
}