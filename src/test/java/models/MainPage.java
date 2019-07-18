package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage {
    private By loginButton = By.cssSelector("button.header2__auth");
    private AuthElem authElem;

    public MainPage(WebDriver wd) {
        super(wd);
        wd.get("http://www.otus.ru/");
        logger.info("main page");
    }

    public RegPage pressLoginButton() {
        click(loginButton);
        logger.info("login button");
        return new RegPage(wd);
    }

    public AuthElem getAuthElem() {
        return authElem;
    }

    public void activatePanel(){
        authElem = new AuthElem(wd);
    }
}
