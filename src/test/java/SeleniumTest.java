import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {

    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    @Test(enabled = false, priority = 1)
    public void test() {
        Assert.assertEquals(Selenium.invalidLogIn(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 2)
    public void test1() {
        Selenium.logIn();
        Assert.assertEquals(Selenium.invalidRequest(), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }
}
