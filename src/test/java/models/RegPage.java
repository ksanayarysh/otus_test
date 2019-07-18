package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPage extends BasePage {

    private By emailField = By.cssSelector("form.new-log-reg__form.js-login input[type=text]");
    private By passwordField = By.cssSelector("form.new-log-reg__form.js-login input[type=password]");
    private By submitButton = By.cssSelector("form.new-log-reg__form.js-login button");

    public RegPage(WebDriver wd) {
        super(wd);
    }

    private void fillEmail(String email) {
        setText(emailField, email);
    }

    private void fillPassword(String password) {
        setText(passwordField, password);
    }

    public PersonalAreaPage login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        click(submitButton);
        new MainPage(wd).activatePanel();
        return new PersonalAreaPage(wd);
    }

}
