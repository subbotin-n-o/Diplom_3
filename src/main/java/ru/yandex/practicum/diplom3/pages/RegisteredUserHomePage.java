package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegisteredUserHomePage extends HomePage {

    private static final String LK_BTN = ".//*[@id='root']/div/header/nav/a/p";

    @FindBy(how = How.XPATH, using = LK_BTN)
    protected SelenideElement lkButton;

    private static final String CHECKOUT = ".//section[2]/div/button";

    @FindBy(how = How.XPATH, using = CHECKOUT)
    private SelenideElement checkoutButton;

    public ProfilePage openProfilePage() {
        lkButton.click();

        profilePage = page(ProfilePage.class);
        profilePage.waitForProfilePage();
        return profilePage;
    }

    public void waitForRegisteredUserHomePage() {
        lkButton.should(visible);
    }
}