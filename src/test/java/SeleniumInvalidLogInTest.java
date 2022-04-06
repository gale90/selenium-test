import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumInvalidLogInTest {
    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    @Test(priority = 1, description = "Empty Email and Password fields")
    public void invalidLogIn() {
        Assert.assertEquals(Selenium.invalidLogIn("", ""), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 2, description = "Empty Email field")
    public void invalidLogIn1() {
        Assert.assertEquals(Selenium.invalidLogIn("", "123456"), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 3, description = "Empty Password field")
    public void invalidLogIn2() {
        Assert.assertEquals(Selenium.invalidLogIn("petrovskidr@gmail.com", ""), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }
}
