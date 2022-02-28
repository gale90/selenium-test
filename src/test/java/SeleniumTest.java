import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {

    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    @Test
    public void test() {
        Assert.assertEquals(Selenium.invalidLogIn(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }
}
