package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;


public class MainPageWithAuth extends BasePage {
    private By personalAreaButton = By.cssSelector("div.header2__right div.header2-menu");
    private By logOut = By.linkText("Выход");
    private By lk = By.linkText("Личный кабинет");

    public MainPageWithAuth(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }


    public PersonalAreaPage gotoPersonalArea() throws InterruptedException {
        sleep(2000);
        click(personalAreaButton);
        click(lk);
        logger.info("personal area");
        return new PersonalAreaPage(wd, wait);
    }

    public void logOut() {
        click(personalAreaButton);
        click(logOut);
        logger.info("log out");
    }
}
