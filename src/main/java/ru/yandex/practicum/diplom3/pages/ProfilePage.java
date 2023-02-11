package ru.yandex.practicum.diplom3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage extends AbstractPage {

    private static final String PROFILE_TEXT = ".//p[contains(text(),'В этом разделе')]";

    @FindBy(how = How.XPATH, using = PROFILE_TEXT)
    private SelenideElement profilePageText;

    public Boolean isProfilePage() {
        return profilePageText.getText().equals("В этом разделе вы можете изменить свои персональные данные");
    }

    @Override
    public void waitPage() {
        profilePageText.should(visible);
    }
}
