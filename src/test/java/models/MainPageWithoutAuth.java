package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageWithoutAuth extends BasePage {
    private By loginButton = By.cssSelector("button.header2__auth");

    public MainPageWithoutAuth(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
        wd.get("http://www.otus.ru/");
        logger.info("main page");
    }

    public RegPage pressLoginButton() {
        click(loginButton);
        logger.info("login button");
        return new RegPage(wd, wait);
    }

}
