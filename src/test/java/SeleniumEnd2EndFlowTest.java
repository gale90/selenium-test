import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumEnd2EndFlowTest {

    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    @Test(priority = 10, description = "Registration form functionality")
    public void verifyRegistrationFormIndividual() {
        Assert.assertEquals(Selenium.registrationForm(1), "ДОБРЕДОЈДОВТЕ!");
    }

    @Test(priority = 12, description = "Registration form functionality")
    public void verifyRegistrationFormCompany() {
        Assert.assertEquals(Selenium.registrationForm(2), "ДОБРЕДОЈДОВТЕ!");
    }

    @Test(priority = 14, description = "Registration form functionality")
    public void verifyRegistrationFormTransporter() {
        Assert.assertEquals(Selenium.registrationForm(3), "ДОБРЕДОЈДОВТЕ!");
    }

    @Test(priority = 20, description = "Log in as user form functionality")
    public void verifyLogInForm() {
        //For logging as user insert 'user', for logging as transporter insert 'transporter'.
        Assert.assertEquals(Selenium.logIn("user"), "http://18.156.17.83:9095/client/home");
    }

    @Test(priority = 30, description = "Send ticket form functionality")
    public void verifySupportForm() {
        Assert.assertEquals(Selenium.supportForm(), "Вашиот меил е успешно испратен до одделот за корисничка поддршка!");
    }

    @Test(priority = 40, description = "Create request form functionality")
    public void verifyCreateFirstRequestForm() {
        Assert.assertEquals(Selenium.newRequestForm(1), "Успешно е креирано ново барање");
    }

    @Test(priority = 42, description = "Create request form functionality")
    public void verifyCreateSecondRequestForm() {
        Assert.assertEquals(Selenium.newRequestForm(2), "Успешно е креирано ново барање");
    }

    @Test(priority = 44, description = "Create request form functionality")
    public void verifyCreateThirdRequestForm() {
        Assert.assertEquals(Selenium.newRequestForm(3), "Успешно е креирано ново барање");
    }

    @Test(priority = 50, description = "Log in as transporter form functionality")
    public void verifyLogInAsTransporterForm() {
        Selenium.logOut();
        Assert.assertEquals(Selenium.logIn("transporter"), "http://18.156.17.83:9095/provider/home");
    }

    @Test(priority = 60, description = "Offer search functionality")
    public void verifySearchOffer() {
        Assert.assertEquals(Selenium.searchOffer(), Selenium.offer1Id);
    }

    @Test(priority = 70, description = "Send an offer functionality")
    public void verifySendFirstOffer() {
        Assert.assertEquals(Selenium.sendOffer(1), "ИЗМЕНИ ЈА ПОНУДАТА");
    }

    @Test(priority = 80, description = "Send an offer functionality")
    public void verifySendSecondOffer() {
        Selenium.navigateToHomepage();
        Assert.assertEquals(Selenium.sendOffer(2), "ИЗМЕНИ ЈА ПОНУДАТА");
    }

    @Test(priority = 90, description = "Log out button functionality")
    public void verifyLogOut() {
        Assert.assertEquals(Selenium.logOut(), "Паметен начин да пронајдеш транспортер");
    }

    @Test(priority = 100, description = "Accept an offer functionality")
    public void verifyFirstAcceptOffer() {
        Selenium.logIn("user");
        Assert.assertEquals(Selenium.acceptOffer(1), "ПРИФАТЕН");
    }

    @Test(priority = 110, description = "Accept an offer functionality")
    public void verifySecondAcceptOffer() {
        Assert.assertEquals(Selenium.acceptOffer(2), "ПРИФАТЕН");
    }

    @Test(priority = 120)
    public void verifyDenyOrder() {
        Assert.assertEquals(Selenium.denyOffer(), "Барањето е успешно избришано");
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }
}
