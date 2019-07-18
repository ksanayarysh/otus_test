import data.Person;
import data.TestData;
import models.AuthElem;
import models.MainPage;
import models.PersonalAreaPage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OtusTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(OtusTest.class);

    @Test
    public void fill_data() throws IOException {
        Person me = TestData.readJson();
        logger.info(me.toString());
        PersonalAreaPage personalAreaPage = new MainPage(driver)
                .pressLoginButton()
                .login(user, password)
                .pressAbout();
        logger.info("logged in");
        personalAreaPage.fillPersonalData(me);
        new AuthElem(driver).logOut();
        personalAreaPage = new MainPage(driver)
                .pressLoginButton()
                .login(user, password)
                .pressAbout();
        Person me_on_the_site = personalAreaPage.getPersonFromSite();
        assert me.equals(me_on_the_site);
      }

    @Test
    public void fill_data1() {
        PersonalAreaPage personalAreaPage = new MainPage(driver)
                .pressLoginButton()
                .login(user, password)
                .pressAbout();
        Person me_on_the_site = personalAreaPage.getPersonFromSite();
        logger.info(me_on_the_site.toString());
    }

    @Test
    public void testWithSom(){
        logger.info(user);
        logger.info(password);
    }

    @Test
    public void testAuth(){
        AuthElem auth = new MainPage(driver).getAuthElem();
        try {
            auth.logOut();
            assert false;
        } catch (NullPointerException np){
            assert true;
        }
    }
}
