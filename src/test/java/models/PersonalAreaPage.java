package models;

import data.Contact;
import data.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    private By contactLink = By.cssSelector("input[name^=contact][name$=value]");
    private By addContactButton = By.cssSelector("button.lk-cv-block__action.lk-cv-block__action_md-no-spacing.js-formset-add.js-lk-cv-custom-select-add");

    public PersonalAreaPage(WebDriver wd) {
        super(wd);
    }

    public String pageUrl() {
        return wd.getCurrentUrl();
    }

    public PersonalAreaPage pressAbout() {
        //click(about);
        wd.get("https://otus.ru/lk/biography/personal/");
        return this;
    }

    public void fillPersonalData(Person me) {
        setText(fname, me.getFirstName());
        setText(lname, me.getLastName());
        setText(fnameLatin, me.getFirstNameEn());
        setText(lnameLatin, me.getLastNameEn());
        setText(blogName, me.getNameInBlog());
        setText(birthDate, me.getBirthDate());
        ((JavascriptExecutor)wd).executeScript("window.scrollBy(0,200);");
        // Setting country
        setCountry(me.getCountry());

        // Setting city
        setCity(me.getCity());

        // Setting contacts
        for (int i = 0; i < me.getContacts().size(); i++) {
            Contact contact = me.getContacts().get(i);
            setContacts(contact.getSocialName(), contact.getSocialLink(), i);
            addContact();

        }

//        setContacts("Facebook", me., 0);
//        setContacts("VK", me.getVk(), 1);
        click(submit);
    }

    private void setContacts(String socialName, String socialLink, int index) {

        wd.findElements(contacts).get(index).click();
        List<WebElement> socialList = wd.findElements(contactButtons);

        for (WebElement social : socialList) {
            if (social.getText().equals(socialName)) {
                social.click();
                WebElement input = wd.findElements(contactLink).get(index);
                setText(input, socialLink);
                break;
            }
        }
    }

    private void addContact() {
        wd.findElement(addContactButton).click();
    }

    private void setCountry(String countryName) {
        // Setting country

        wd.findElement(country).click();
        List<WebElement> countries = wd.findElements(countryButtons);
        assert countries.size() > 0;
        for (WebElement country : countries) {
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

    public Person getPersonFromSite() {
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

        List<WebElement> contactList = wd.findElements(contacts);
        for (int i = 0; i < contactList.size(); i++){
            WebElement we = contactList.get(i);
            String socialName = we.getText().trim();
            String socialLink = getValue(wd.findElements(contactLink).get(i));
            p.addContact(new Contact(socialName, socialLink));
        }

        logger.info(p.toString());
        return p;
    }

    private String getValue(By locator) {
        return wd.findElement(locator).getAttribute("value");
    }

    private String getValue(WebElement we) {
        return we.getAttribute("value").trim();
    }

    private String getTextContent(By locator) {
        return wd.findElement(locator).getAttribute("textContent").trim() ;
    }



}
