import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    @BeforeMethod
    public void setUp() {
        Selenium.setUp();
    }

    @Test(priority = 1, description = "Login without username and password")
    public void verifyUserCannotLogIn() {
        Assert.assertEquals(Selenium.invalidLogIn(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 2, description = "Submit empty form")
    public void verifyUserCannotCreateRequest() {
        Selenium.logIn();
        Assert.assertEquals(Selenium.invalidRequest(), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @AfterMethod
    public void quit() {
        Selenium.quit();
    }
}
