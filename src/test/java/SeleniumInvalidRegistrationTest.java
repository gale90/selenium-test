import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumInvalidRegistrationTest {
    String user = "gale" + System.currentTimeMillis() + "@test.com";


    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }

    @Test(priority = 10, description = "Verify the user cannot be registered with empty first name field")
    public void emptyNameFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(1, "", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", user, "123456", "123456"), "Ве молиме пополнете ги сите задолжителни полиња!");
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(2, "", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 20, description = "Verify the user cannot be registered with empty last name field")
    public void emptyLastNameFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(3, "Dragan", "", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 30, description = "Verify the user cannot be registered with empty address field")
    public void emptyAddressFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(4, "Dragan", "Petrovski", "", "Skopje", "1000", "Macedonia", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 40, description = "Verify the user cannot be registered with empty city field")
    public void emptyCityFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(5, "Dragan", "Petrovski", "Partizan 10", "", "1000", "Macedonia", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 50, description = "Verify the user cannot be registered with empty postal code field")
    public void emptyPostalCodeFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(6, "Dragan", "Petrovski", "Partizan 10", "Skopje", "", "Macedonia", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 60, description = "Verify the user cannot be registered with empty country field")
    public void emptyCountryFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(7, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 60, description = "Verify the user cannot be registered with empty phone number field")
    public void emptyPhoneNumberFieldRegistrationAsIndividualForm() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(8, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "", user, "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 70, description = "Verify the user cannot be registered with empty email field")
    public void emptyEmailFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(9, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "", "123456", "123456"), "Задолжително внесете ваш e-mail.");
    }

    @Test(priority = 80, description = "Verify the user cannot be registered with empty password field")
    public void emptyPasswordFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(10, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", user, "", "123456"), "Задолжително внесете лозинка");
    }

    @Test(priority = 90, description = "Verify the user cannot be registered with empty confirm password field")
    public void emptyConfirmPasswordFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(11, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", user, "123456", ""), "Задолжително потврдете ја лозинката.");
    }

    @Test(priority = 100, description = "Verify the user cannot be registered with unchecked terms and conditions")
    public void uncheckTermsAndConditionsRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(12, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", user, "123456", "123456"), "Ова поле е задолжително.");
    }
}
