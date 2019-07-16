package models;

import data.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class PersonalAreaPage extends BasePage {
    private By about = By.partialLinkText("О себе");
    private By fname = By.name("fname");
    private By fnameLatin = By.name("fname_latin");
    private By lname = By.name("lname");
    private By lnameLatin = By.name("lname_latin");
    private By blogName = By.name("blog_name");
    private By birthDate = By.name("date_of_birth");
    private By country = By.cssSelector("div.select.lk-cv-block__input.lk-cv-block__input_full.js-lk-cv-dependent-master.js-lk-cv-custom-select");
    private By getCountry = By.cssSelector("div.select.lk-cv-block__input.lk-cv-block__input_full.js-lk-cv-dependent-master.js-lk-cv-custom-select div");
    private By city = By.cssSelector(
            "div.select.lk-cv-block__input.lk-cv-block__input_full.js-lk-cv-dependent-slave-city.js-lk-cv-custom-select");
    private By getCity = By.cssSelector(
            "div.select.lk-cv-block__input.lk-cv-block__input_full.js-lk-cv-dependent-slave-city.js-lk-cv-custom-select div");
    private By contacts = By.cssSelector(
            "div.lk-cv-block__input.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation");
    private By submit = By.cssSelector("div.lk-cv-action-buttons button");
    private By countryButtons = By.cssSelector("button.lk-cv-block__select-option.js-custom-select-option");
    private By cityButtons = By.cssSelector("div.lk-cv-block__select-scroll.lk-cv-block__select-scroll_city.js-custom-select-options button");
    private By contactButtons = By.cssSelector("div.lk-cv-block__select-scroll.lk-cv-block__select-scroll_service.js-custom-select-options button");

    private By contactLink1 = By.cssSelector("input[name=contact-0-value]");
    private By contactLink2 = By.cssSelector("input[name=contact-1-value]");
    private By addContactButton = By.cssSelector("button.lk-cv-block__action.lk-cv-block__action_md-no-spacing.js-formset-add.js-lk-cv-custom-select-add");

    public PersonalAreaPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public String pageUrl(){
        return wd.getCurrentUrl();
    }

    public PersonalAreaPage pressAbout(){
        click(about);
        return this;
    }

    public void fillPersonalData(Person me) throws IOException {
        setText(fname, me.getFirstName());
        setText(lname, me.getLastName());
        setText(fnameLatin, me.getFirstNameEn());
        setText(lnameLatin, me.getLastNameEn());
        setText(blogName, me.getNameInBlog());
        setText(birthDate, me.getBirthDate());
        // Setting country
        setCountry(me.getCountry());

        // Setting city
        setCity(me.getCity());

        // Setting contacts
        setContacts(me);
        click(submit);
    }

    private void setContacts(Person me) {

        wd.findElement(contacts).click();
        List<WebElement> socialList = wd.findElements(contactButtons);

        for (WebElement social : socialList) {
            if (social.getText().equals("Facebook")) {
                social.click();
                setText(contactLink1, me.getFb());
                break;
            }
        }

        wd.findElement(addContactButton).click();

        wd.findElements(contacts).get(1).click();
        List<WebElement> contacts = wd.findElements(contactButtons);

        for (WebElement con : contacts) {
            if (con.getText().equals("VK")) {
                con.click();
                setText(contactLink2, me.getVk());
                break;
            }
        }
    }

    private void setCountry(String countryName) {
        // Setting country

        wd.findElement(country).click();
        List<WebElement> countries = wd.findElements(countryButtons);
        assert countries.size() > 0;
        for (WebElement country: countries) {
            if (country.getText().equals(countryName)) {
                country.click();
                break;
            }
        }
    }

    private void setCity(String cityName) {
        // Setting city
        wd.findElement(city).click();
        List<WebElement> cities = wd.findElements(cityButtons);
        for (WebElement city : cities) {
            if (city.getText().equals(cityName)) {
                city.click();
                break;
            }
        }
    }

    public Person getPersonFromSite(){
        logger.info("get person info from site");
        Person p = new Person();
        p.setFirstName(getValue(fname));
        p.setLastName(getValue(lname));
        p.setFirstNameEn(getValue(fnameLatin));
        p.setLastNameEn(getValue(lnameLatin));
        p.setNameInBlog(getValue(blogName));
        p.setBirthDate(getValue(birthDate));
        p.setCountry(getTextContent(getCountry).trim());
        p.setCity(getTextContent(getCity).trim());
        p.setFb(getValue(contactLink1));
        p.setVk(getValue(contactLink2));
        logger.info(p.toString());
        return p;
    }

    private String getValue(By locator) {
        return wd.findElement(locator).getAttribute("value");
    }

    private String getTextContent(By locator) {
        return wd.findElement(locator).getAttribute("textContent");
    }

}
