package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends AbstractPage {

    private static final String RESTORE_PASSWORD_HEADER = ".//h2[contains(text(),'Восстановление пароля')]";
    private static final String SIGN_IN_BTN = ".//a[contains(text(),'Войти')]";

    @FindBy(how = How.XPATH, using = RESTORE_PASSWORD_HEADER)
    private SelenideElement forgotPasswordHeader;

    @FindBy(how = How.XPATH, using = SIGN_IN_BTN)
    private SelenideElement signInButton;

    public LoginPage openLoginPage() {
        clickSignInButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitPage();
        return loginPage;
    }

    private void clickSignInButton() {
        signInButton.click();
    }

    @Override
    public void waitPage() {
        forgotPasswordHeader.should(visible);
    }

}