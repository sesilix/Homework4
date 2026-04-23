package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class FacebookRegistrationPage extends BasePage {

    private final SelenideElement createAccountButton = $("a[href*='/reg/']");

    private final SelenideElement firstNameInput = $$("input[type='text']").get(0);
    private final SelenideElement lastNameInput = $$("input[type='text']").get(1);

    private final SelenideElement emailInput = $$("input").get(2);
    private final SelenideElement passwordInput = $$("input").get(3);

    private final SelenideElement monthBox = $$("div[role='combobox']").get(0);
    private final SelenideElement dayBox = $$("div[role='combobox']").get(1);
    private final SelenideElement yearBox = $$("div[role='combobox']").get(2);
    private final SelenideElement genderBox = $$("div[role='combobox']").get(3);
    private final SelenideElement pronounBox = $$("div[role='combobox']").get(4);

    private final SelenideElement genderInput =
            $("input[aria-label*='gender'], input[name*='gender'], input[placeholder*='gender']");

    @Step("გავხსნათ Facebook-ის მთავარი გვერდი")
    public void openPage() {
        open("/");
    }

    @Step("დავაჭიროთ Create New Account ღილაკს")
    public void clickCreateNewAccount() {
        createAccountButton.shouldBe(visible).click();
    }

    @Step("შევავსოთ სახელი: {firstName}")
    public void enterFirstName(String firstName) {
        firstNameInput.shouldBe(visible, enabled).setValue(firstName);
    }

    @Step("შევავსოთ გვარი: {lastName}")
    public void enterLastName(String lastName) {
        lastNameInput.shouldBe(visible, enabled).setValue(lastName);
    }

    @Step("შევავსოთ მობილური/მეილი: {email}")
    public void enterEmail(String email) {
        emailInput.shouldBe(visible, enabled).setValue(email);
    }

    @Step("შევავსოთ პაროლი")
    public void enterPassword(String password) {
        passwordInput.shouldBe(visible, enabled).setValue(password);
    }

    @Step("შევავსოთ დაბადების თარიღი")
    public void selectBirthDate(String day, String month, String year) {
        monthBox.shouldBe(visible).click();
        $(byText(month)).shouldBe(visible).click();

        dayBox.shouldBe(visible).click();
        $(byText(day)).shouldBe(visible).click();

        yearBox.shouldBe(visible).click();
        $(byText(year)).shouldBe(visible).click();
    }

    @Step("ავირჩიოთ Custom gender")
    public void selectCustomGender() {
        genderBox.shouldBe(visible).click();
        $(byText("Custom")).shouldBe(visible).click();
    }

    @Step("შევავსოთ მომართვა: {pronoun}")
    public void selectPronoun(String pronoun) {
        pronounBox.shouldBe(visible).click();
        $(byText(pronoun)).shouldBe(visible).click();
    }

    @Step("შევავსოთ custom gender ტექსტი: {gender}")
    public void enterCustomGender(String gender) {
        genderInput.shouldBe(visible, enabled).setValue(gender);
    }

    @Step("ავირჩიოთ Female gender")
    public void selectFemaleGender() {
        genderBox.shouldBe(visible).click();
        $(byText("Female")).shouldBe(visible).click();
    }

    public SelenideElement getPronounSelect() {
        return pronounBox;
    }

    public SelenideElement getGenderInput() {
        return genderInput;
    }
}