package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement logienField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement logienButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    // метод для проверки видимости сообщения об ошибку
    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(exactText(expectedText)).shouldBe(visible);
    }

    // метод для валидного логина который возвращает VerificationPage
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        logienField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        logienButton.click();
        return new VerificationPage();
    }
}