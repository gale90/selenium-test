import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumInvalidRegistrationTest {


    @BeforeClass
    public void setUp() {
        Selenium.setUp();
    }

    //register as person
    @Test(priority = 10, description = "Verify the user cannot be registered with empty first name field")
    public void emptyNameFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(1, "", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ве молиме пополнете ги сите задолжителни полиња!");
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(2, "", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 20, description = "Verify the user cannot be registered with empty last name field")
    public void emptyLastNameFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(3, "Dragan", "", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 30, description = "Verify the user cannot be registered with empty address field")
    public void emptyAddressFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(4, "Dragan", "Petrovski", "", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 40, description = "Verify the user cannot be registered with empty city field")
    public void emptyCityFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(5, "Dragan", "Petrovski", "Partizan 10", "", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 50, description = "Verify the user cannot be registered with empty postal code field")
    public void emptyPostalCodeFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(6, "Dragan", "Petrovski", "Partizan 10", "Skopje", "", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 60, description = "Verify the user cannot be registered with empty country field")
    public void emptyCountryFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(7, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 60, description = "Verify the user cannot be registered with empty phone number field")
    public void emptyPhoneNumberFieldRegistrationAsIndividualForm() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(8, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 70, description = "Verify the user cannot be registered with empty email field")
    public void emptyEmailFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(9, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "", "123456", "123456"), "Задолжително внесете ваш e-mail.");
    }

    @Test(priority = 80, description = "Verify the user cannot be registered with empty password field")
    public void emptyPasswordFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(10, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "", "123456"), "Задолжително внесете лозинка");
    }

    @Test(priority = 90, description = "Verify the user cannot be registered with empty confirm password field")
    public void emptyConfirmPasswordFieldRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(11, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", ""), "Задолжително потврдете ја лозинката.");
    }

    @Test(priority = 100, description = "Verify the user cannot be registered with unchecked terms and conditions")
    public void uncheckTermsAndConditionsRegistrationAsIndividualForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsIndividualForm(12, "Dragan", "Petrovski", "Partizan 10", "Skopje", "1000", "Macedonia", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    //register as company
    @Test(priority = 110, description = "Verify the user cannot be registered with empty first name field")
    public void emptyNameFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(1, "", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ве молиме пополнете ги сите задолжителни полиња!");
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(2, "", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 110, description = "Verify the user cannot be registered with empty last first name field")
    public void emptyLastNameFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(3, "Dragan", "", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 130, description = "Verify the user cannot be registered with empty company name field")
    public void emptyCompanyNameFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(4, "Dragan", "Petrovski", "", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 140, description = "Verify the user cannot be registered with empty address field")
    public void emptyAddressFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(5, "Dragan", "Petrovski", "Brainster", "", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 150, description = "Verify the user cannot be registered with empty city field")
    public void emptyCityFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(6, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 160, description = "Verify the user cannot be registered with empty post code field")
    public void emptyPostCodeFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(7, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 170, description = "Verify the user cannot be registered with empty country field")
    public void emptyCountryFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(8, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 180, description = "Verify the user cannot be registered with empty tax number field")
    public void emptyTaxNumberFieldRegistrationAsCompanyForm() {
        Assert.assertNotEquals(Selenium.invalidRegistrationAsCompanyForm(9, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "http://18.156.17.83:9095/account-type/register-client/client-successful-registration");
    }

    @Test(priority = 190, description = "Verify the user cannot be registered with empty phone number field")
    public void emptyPhoneNumberFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(10, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 200, description = "Verify the user cannot be registered with empty email field")
    public void emptyEmailFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(11, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "", "123456", "123456"), "Задолжително внесете ваш e-mail.");
    }

    @Test(priority = 210, description = "Verify the user cannot be registered with empty password field")
    public void emptyPasswordFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(12, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "", "123456"), "Задолжително внесете лозинка");
    }

    @Test(priority = 220, description = "Verify the user cannot be registered with empty confirm password field")
    public void emptyConfirmPasswordFieldRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(13, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", ""), "Задолжително потврдете ја лозинката.");
    }

    @Test(priority = 230, description = "Verify the user cannot be registered with unchecked terms and conditions checkbox")
    public void uncheckedTermsAndConditionsRegistrationAsCompanyForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsCompanyForm(14, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    //register as transporter
    @Test(priority = 240, description = "Verify the user cannot be registered with empty first name field")
    public void emptyNameFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(1, "", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ве молиме пополнете ги сите задолжителни полиња!");
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(2, "", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 250, description = "Verify the user cannot be registered with empty last name field")
    public void emptyLastNameFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(3, "Dragan", "", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 260, description = "Verify the user cannot be registered with empty company name field")
    public void emptyCompanyNameFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(4, "Dragan", "Petrovski", "", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 270, description = "Verify the user cannot be registered with empty address field")
    public void emptyAddressFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(5, "Dragan", "Petrovski", "Brainster", "", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 280, description = "Verify the user cannot be registered with empty city field")
    public void emptyCityFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(6, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 290, description = "Verify the user cannot be registered with empty post code field")
    public void emptyPostCodeFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(7, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 300, description = "Verify the user cannot be registered with empty country field")
    public void emptyCountryFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(8, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 310, description = "Verify the user cannot be registered with empty tax number field")
    public void emptyTaxNumberFieldRegistrationAsTransporterForm() {
        Assert.assertNotEquals(Selenium.invalidRegistrationAsTransporterForm(9, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "http://18.156.17.83:9095/account-type/register-provider/provider-successful-registration");
    }

    @Test(priority = 320, description = "Verify the user cannot be registered with empty phone number field")
    public void emptyPhoneNumberFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(10, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @Test(priority = 330, description = "Verify the user cannot be registered with empty email field")
    public void emptyEmailFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(11, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "", "123456", "123456"), "Задолжително внесете ваш e-mail.");
    }

    @Test(priority = 340, description = "Verify the user cannot be registered with empty password field")
    public void emptyPasswordFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(12, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "", "123456"), "Задолжително внесете лозинка");
    }

    @Test(priority = 350, description = "Verify the user cannot be registered with empty confirm password field")
    public void emptyConfirmPasswordFieldRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(13, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", ""), "Задолжително потврдете ја лозинката.");
    }

    @Test(priority = 360, description = "Verify the user cannot be registered with unchecked terms and conditions checkbox")
    public void uncheckedTermsAndConditionsRegistrationAsTransporterForm() {
        Assert.assertEquals(Selenium.invalidRegistrationAsTransporterForm(14, "Dragan", "Petrovski", "Brainster", "Partizanska 10", "Skopje", "1000", "Macedonia", "1234567899874", "070123456", "gale" + System.currentTimeMillis() + "@test.com", "123456", "123456"), "Ова поле е задолжително.");
    }

    @AfterClass
    public void quit() {
        Selenium.quit();
    }
}
