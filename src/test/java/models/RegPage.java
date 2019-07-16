package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage extends BasePage {

    private By emailField = By.cssSelector("form.new-log-reg__form.js-login input[type=text]");
    private By passwordField = By.cssSelector("form.new-log-reg__form.js-login input[type=password]");
    private By submitButton = By.cssSelector("form.new-log-reg__form.js-login button");

    public RegPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    private void fillEmail(String email) {
        setText(emailField, email);
    }

    private void fillPassword(String password) {
        setText(passwordField, password);
    }

    public MainPageWithAuth login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        click(submitButton);
        return new MainPageWithAuth(wd, wait);
    }

}
