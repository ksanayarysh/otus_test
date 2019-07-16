package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected WebDriver wd;
    protected WebDriverWait wait;
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);


    public BasePage(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public void click(By locator) {

//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        wd.findElement(locator).click();
    }

    public void setText(By locator, String text) {
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        we.clear();
        we.sendKeys(text);
        we.click();

    }
}
