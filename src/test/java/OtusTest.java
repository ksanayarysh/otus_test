import data.Person;
import data.TestData;
import models.MainPageWithAuth;
import models.MainPageWithoutAuth;
import models.PersonalAreaPage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OtusTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(OtusTest.class);

    @Test
    public void fill_data() throws IOException, InterruptedException {
        Person me = TestData.readJson();
        logger.info(me.toString());
        PersonalAreaPage pap = new MainPageWithoutAuth(driver, wait)
                .pressLoginButton()
                .login(user, password)
                .gotoPersonalArea();
        logger.info("logged in");
        pap.pressAbout().fillPersonalData(me);
        new MainPageWithAuth(driver, wait).logOut();
        pap = new MainPageWithoutAuth(driver, wait)
                .pressLoginButton()
                .login(user, password)
                .gotoPersonalArea();
        Person me_on_the_site = pap.pressAbout().getPersonFromSite();
        assert me.equals(me_on_the_site);
      }

    @Test
    public void fill_data1() throws InterruptedException {
        PersonalAreaPage pap = new MainPageWithoutAuth(driver, wait)
                .pressLoginButton()
                .login(user, password)
                .gotoPersonalArea();
        pap.pressAbout().getPersonFromSite();


    }

    @Test
    public void testWithSom(){
        logger.info(user);
        logger.info(password);
    }
}
