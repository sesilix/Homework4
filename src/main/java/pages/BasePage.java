package pages;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.visible;

public class BasePage {
    public BasePage() {
        Configuration.baseUrl = "https://www.facebook.com";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 8000;
    }


}