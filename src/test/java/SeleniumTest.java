import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    @Test(priority = 10, description = "Registration form functionality")
    public void verifyRegistrationForm() {
        Assert.assertEquals(Selenium.registrationForm(1), "ДОБРЕДОЈДОВТЕ!");
        Assert.assertEquals(Selenium.registrationForm(3), "ДОБРЕДОЈДОВТЕ!");
    }

    @Test(priority = 20, description = "Log in as user form functionality")
    public void verifyLogInForm() {
        //For logging as user insert 'user', for logging as transporter insert 'transporter'.
        Assert.assertEquals(Selenium.logIn("user"), "http://18.156.17.83:9095/account-type/register-provider/provider-successful-registration");
    }

    @Test(priority = 30, description = "Send ticket form functionality")
    public void verifySupportForm() {
        Assert.assertEquals(Selenium.supportForm(), "Вашиот меил е успешно испратен до одделот за корисничка поддршка!");
    }

    @Test(priority = 40, description = "Create request form functionality")
    public void verifyCreateRequestForm() {
//        Assert.assertEquals(Selenium.newRequestForm(1), "Успешно е креирано ново барање");
//        Assert.assertEquals(Selenium.newRequestForm(2), "Успешно е креирано ново барање");
        Assert.assertEquals(Selenium.newRequestForm(3), "Успешно е креирано ново барање");
    }

    @Test(priority = 50, description = "Log in as transporter form functionality")
    public void verifyLogInAsTransporterForm() {
        Selenium.logOut();
        Assert.assertEquals(Selenium.logIn("transporter"), "http://18.156.17.83:9095/");
    }

    @Test(priority = 60, description = "Offer search functionality")
    public void verifySearchOffer() {
        Selenium.searchOffer();
    }

    @Test(priority = 70, description = "Send an offer functionality")
    public void verifySendOffer() {
        Assert.assertEquals(Selenium.sendOffer(), "ИЗМЕНИ ЈА ПОНУДАТА");
    }

    @Test(priority = 80, description = "Log out button functionality")
    public void verifyLogOut() {
        Assert.assertEquals(Selenium.logOut(), "Паметен начин да пронајдеш транспортер");
    }

    @Test(priority = 90, description = "Accept an offer functionality")
    public void verifyAcceptOffer() {
        Selenium.logIn("user");
        Assert.assertEquals(Selenium.acceptOffer(), "ПРИФАТЕН");
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }
}
