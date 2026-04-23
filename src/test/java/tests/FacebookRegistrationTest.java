package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.FacebookRegistrationPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.hidden;

@Epic("Facebook")
@Feature("Registration Page")
public class FacebookRegistrationTest extends BaseTest {

    @Test
    @Description("Facebook-ის რეგისტრაციის ფორმის შევსება და Custom სქესის შემოწმება")
    public void testFacebookRegistration() {
        FacebookRegistrationPage page = new FacebookRegistrationPage();


        page.openPage();
        page.clickCreateNewAccount();

        page.enterFirstName("sesili");
        page.enterLastName("khubua");
        page.enterEmail("sesilikhubua0@gmail.com");
        page.enterPassword("Paroli2@");

        page.selectBirthDate("20", "April", "2001");

        page.selectCustomGender();

        page.getPronounSelect().shouldBe(visible);

        page.selectPronoun("She: \"Wish her a happy birthday!\"");

        page.selectFemaleGender();

        page.getPronounSelect().shouldBe(hidden);
        page.getGenderInput().shouldBe(hidden);
    }
}