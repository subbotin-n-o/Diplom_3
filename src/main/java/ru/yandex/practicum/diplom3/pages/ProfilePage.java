package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    private static final String PROFILE_TEXT = ".//nav/p";

    @FindBy(how = How.XPATH, using = PROFILE_TEXT)
    private SelenideElement profilePageText;

    public void waitForProfilePage() {
        profilePageText.should(visible);
    }

    public Boolean isProfilePage() {
        return profilePageText.getText().equals("В этом разделе вы можете изменить свои персональные данные");
    }
}
