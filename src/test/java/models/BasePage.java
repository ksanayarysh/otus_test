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
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);


    public BasePage(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {

//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        wd.findElement(locator).click();
    }

    public void setText(By locator, String text) {
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement we = wd.findElement(locator);
        we.clear();
        we.sendKeys(text);
        we.click();

    }

    public void setText(WebElement we, String text) {
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        we.clear();
        we.sendKeys(text);
        we.click();

    }
}
