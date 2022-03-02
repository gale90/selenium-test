import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Selenium {


    private static WebDriver driver;

    static String user = "gale" + System.currentTimeMillis() + "@test.com";
    static String password = "123456";
    static String offer1Id = UUID.randomUUID().toString();
    static String offer2Id = UUID.randomUUID().toString();
    static String offer3Id = UUID.randomUUID().toString();

    static String userTransporter = "gale" + System.currentTimeMillis() + "@test.com";
    static String passwordTransporter = "123456";

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-98.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://18.156.17.83:9095/");
    }

    public static void quit() {
        driver.quit();
    }

    public static String invalidLogIn() {
        WebElement logInBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/span[2]"));
        logInBtn.click();

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div")).getText();
    }

    public static String invalidRequest() {
        WebElement createRequestBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]"));
        createRequestBtn.click();

        WebElement submitRequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[13]/input"));
        submitRequestBtn.click();

        return driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[13]/div/p")).getText();
    }

    //valid flow
    public static String logIn(String userOption) {
        WebElement logInBtn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        logInBtn.click();
        WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));

        switch (userOption) {
            case "user":
                usernameTxt.sendKeys(user);

                passwordTxt.sendKeys(password);

                logMeInBtn.click();
                break;

            case "transporter":
                usernameTxt.sendKeys(userTransporter);

                passwordTxt.sendKeys(passwordTransporter);

                logMeInBtn.click();
                break;
        }
        return driver.getCurrentUrl();
    }

    public static String logOut() {
        WebElement logOutBtn = driver.findElement(By.xpath("//*[@id=\"logout2\"]/span"));
        logOutBtn.click();

        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/h1")).getText();
    }

    public static String registrationForm(int userType) {
        WebElement registerBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a/span"));
        registerBtn.click();

        switch (userType) {
            //register individual
            case 1:
                for (int i = 0; i <= 2; i++) {
                    try {
                        WebElement lookingForTransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/button"));
                        lookingForTransporterBtn.click();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                Select typeOfClientDD = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select")));
                typeOfClientDD.selectByIndex(0);

                WebElement nameTxt = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
                nameTxt.sendKeys("Dragan");

                WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input"));
                lastNameTxt.sendKeys("Petrovski");

                WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input"));
                addressTxt.sendKeys("Partizanski odredi 90");

                WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input"));
                cityTxt.sendKeys("Skopje");

                WebElement postalCodeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input"));
                postalCodeTxt.sendKeys("1000");

                WebElement countryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/div[1]/span"));
                countryBtn.click();
                WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/input[1]"));
                countryTxt.sendKeys("Macedonia");
                countryTxt.sendKeys(Keys.ENTER);

                WebElement phoneNmbrTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/input"));
                phoneNmbrTxt.sendKeys("+38970123456");

                WebElement emailTxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
                emailTxt.sendKeys(user);

                WebElement passTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
                passTxt.sendKeys(password);

                WebElement confirmPassTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
                confirmPassTxt.sendKeys(password);

                WebElement termsAndConditionsCB = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
                termsAndConditionsCB.click();

                WebElement registerMeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input"));
                registerMeBtn.click();
                break;

            // register company
            case 2:
                WebElement registerCmpBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a/span"));
                registerCmpBtn.click();

                for (int i = 0; i <= 1; i++) {
                    try {
                        WebElement lookingForTransporterCmpBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/button"));
                        lookingForTransporterCmpBtn.click();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                Select typeOfClientCmpDD = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select")));
                typeOfClientCmpDD.selectByIndex(1);

                WebElement nameCmpTxt = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
                nameCmpTxt.sendKeys("Dragan");

                WebElement lastNameCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input"));
                lastNameCmpTxt.sendKeys("Petrovski");

                WebElement compNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input"));
                compNameTxt.sendKeys("Brainster");

                WebElement addressCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input"));
                addressCmpTxt.sendKeys("Partizanski odredi 90");

                WebElement cityCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input"));
                cityCmpTxt.sendKeys("Skopje");

                WebElement postalCodeCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/input"));
                postalCodeCmpTxt.sendKeys("1000");

                WebElement countryCmpBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/country-selector/div/div[1]/span"));
                countryCmpBtn.click();
                WebElement countryCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/country-selector/div/input[1]"));
                countryCmpTxt.sendKeys("Macedonia");
                countryCmpTxt.sendKeys(Keys.ENTER);

                WebElement taxNmbrCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[11]/div[2]/input"));
                taxNmbrCmpTxt.sendKeys("1234567891234");

                WebElement phoneNmbrCmpTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[12]/div[2]/input"));
                phoneNmbrCmpTxt.sendKeys("+38970123456");

                WebElement emailCmpTxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
                emailCmpTxt.sendKeys(user);

                WebElement passCmpTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
                passCmpTxt.sendKeys(password);

                WebElement confirmPassCmpTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
                confirmPassCmpTxt.sendKeys(password);

                WebElement termsAndConditionsCmpCB = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
                termsAndConditionsCmpCB.click();

                WebElement registerMeCmpBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input"));
                registerMeCmpBtn.click();
                break;

            //register transporter
            case 3:
                WebElement iAmTransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/button"));
                iAmTransporterBtn.click();

                WebElement nameTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[1]/div[2]/input"));
                nameTransTxt.sendKeys("Dragan");

                WebElement lastNameTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/input"));
                lastNameTransTxt.sendKeys("Petrovski");

                WebElement companyNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[5]/div[2]/input"));
                companyNameTxt.sendKeys("Brainster");

                WebElement addressTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[7]/div[2]/input"));
                addressTransTxt.sendKeys("Partizanska 90");

                WebElement cityTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[9]/div[2]/input"));
                cityTransTxt.sendKeys("Skopje");

                WebElement postalCodeTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[11]/div[2]/input"));
                postalCodeTransTxt.sendKeys("1000");

                WebElement countryTransBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/div[1]/span"));
                countryTransBtn.click();
                WebElement countryTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/input[1]"));
                countryTransTxt.sendKeys("Macedonia");
                countryTransTxt.sendKeys(Keys.ENTER);

                WebElement taxNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[15]/div[2]/input"));
                taxNumberTxt.sendKeys("1231231231231");

                WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[16]/div[2]/input"));
                phoneNumberTxt.sendKeys("070123456");

                WebElement emailTransTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[2]/div[2]/input"));
                emailTransTxt.sendKeys(userTransporter);

                WebElement passTransTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
                passTransTxt.sendKeys(passwordTransporter);

                WebElement confirmPassTransTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
                confirmPassTransTxt.sendKeys(passwordTransporter);

                WebElement termsAndConditionsTransCB = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
                termsAndConditionsTransCB.click();

                WebElement registerMeTransBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[10]/input"));
                registerMeTransBtn.click();
                break;
        }
        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/h1")).getText();
    }

    public static String supportForm() {
        WebElement clientSuppBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[6]/a/span[2]"));
        clientSuppBtn.click();

        WebElement subjectTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div[1]/input"));
        subjectTxt.sendKeys("Lorem ipsum dolor sit amet");

        WebElement questionTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div[2]/textarea"));
        questionTxt.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus in metus luctus, tincidunt enim ac, tempus velit. Proin malesuada justo vitae quam volutpat consectetur. Etiam efficitur, velit eu facilisis finibus, mi dolor tempus diam, eget vulputate lacus sapien ac ipsum. Suspendisse posuere vel mi nec sagittis. Nulla facilisi. Curabitur purus lorem, semper ac ultrices quis, blandit a libero. Curabitur a ante eu nisi vestibulum semper eget at mauris.");

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/button"));
        submitBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[1]/strong")).getText();
    }

    public static String newRequestForm(int category) {
        switch (category) {

            case 1:
                WebElement requestBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]"));
                requestBtn.click();

                WebElement titleTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
                titleTxt.sendKeys(offer1Id);

                Select categoryDD = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
                categoryDD.selectByIndex(1);

                WebElement fromAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
                fromAddressTxt.sendKeys("Partizanska 10");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fromAddressTxt.sendKeys(Keys.ARROW_DOWN);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fromAddressTxt.sendKeys(Keys.ENTER);

                WebElement toAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
                toAddressTxt.sendKeys("Partizanska 20" + Keys.ARROW_DOWN + Keys.ENTER);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toAddressTxt.sendKeys(Keys.ARROW_DOWN);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toAddressTxt.sendKeys(Keys.ENTER);

                WebElement pickUpDateCB = driver.findElement(By.xpath("//*[@id=\"setPickUpDate\"]"));
                pickUpDateCB.click();

                WebElement earliestPickUpDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[1]/input"));
                earliestPickUpDateTxt.sendKeys("10.05.2022");

                WebElement latestPickUpDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[2]/input"));
                latestPickUpDateTxt.sendKeys("15.05.2022");

                WebElement deliveryCB = driver.findElement(By.xpath("//*[@id=\"setDeliveryUpDate\"]"));
                deliveryCB.click();

                WebElement earliestDeliveryTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[1]/input"));
                earliestDeliveryTxt.sendKeys("10.06.2022");

                WebElement latestDeliveryDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[2]/input"));
                latestDeliveryDateTxt.sendKeys("15.06.2022");

                WebElement weightTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[1]/div[2]/input"));
                weightTxt.sendKeys("10");

                WebElement volumeTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[2]/input"));
                volumeTxt.sendKeys("20");

                WebElement descriptionTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[3]/div[2]/textarea"));
                descriptionTxt.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend, neque faucibus vestibulum venenatis, nisi turpis fermentum sem, sed pulvinar dolor sem vel nulla. Nullam vel odio ac eros accumsan convallis quis facilisis enim. Maecenas est ligula, ultrices nec gravida sed, varius non metus. Nam lectus massa, aliquam ac dolor sit amet, convallis sagittis nisl. Quisque in justo et ipsum faucibus pharetra. Suspendisse sed arcu ac ligula feugiat cursus. Curabitur viverra ligula ut lorem feugiat porta.");

                WebElement paymentCashMethodCB = driver.findElement(By.xpath("//*[@id=\"cachePickup\"]"));
                paymentCashMethodCB.click();

                WebElement submitRequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
                submitRequestBtn.click();
                break;

            case 2:
                WebElement requestBtn1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]"));
                requestBtn1.click();

                WebElement titleTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
                titleTxt1.sendKeys(offer2Id);

                Select categoryDD1 = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
                categoryDD1.selectByIndex(2);

                WebElement fromAddressTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
                fromAddressTxt1.sendKeys("Partizanska 10");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fromAddressTxt1.sendKeys(Keys.ARROW_DOWN);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fromAddressTxt1.sendKeys(Keys.ENTER);

                WebElement toAddressTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
                toAddressTxt1.sendKeys("Partizanska 20" + Keys.ARROW_DOWN + Keys.ENTER);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toAddressTxt1.sendKeys(Keys.ARROW_DOWN);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toAddressTxt1.sendKeys(Keys.ENTER);

                WebElement pickUpDateCB1 = driver.findElement(By.xpath("//*[@id=\"setPickUpDate\"]"));
                pickUpDateCB1.click();

                WebElement earliestPickUpDateTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[1]/input"));
                earliestPickUpDateTxt1.sendKeys("10.05.2022");

                WebElement latestPickUpDateTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[2]/input"));
                latestPickUpDateTxt1.sendKeys("15.05.2022");

                WebElement deliveryCB1 = driver.findElement(By.xpath("//*[@id=\"setDeliveryUpDate\"]"));
                deliveryCB1.click();

                WebElement earliestDeliveryTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[1]/input"));
                earliestDeliveryTxt1.sendKeys("10.06.2022");

                WebElement latestDeliveryDateTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[2]/input"));
                latestDeliveryDateTxt1.sendKeys("15.06.2022");

                WebElement weightTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[1]/div[2]/input"));
                weightTxt1.sendKeys("10");

                WebElement volumeTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[2]/input"));
                volumeTxt1.sendKeys("20");

                WebElement descriptionTxt1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[3]/div[2]/textarea"));
                descriptionTxt1.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend, neque faucibus vestibulum venenatis, nisi turpis fermentum sem, sed pulvinar dolor sem vel nulla. Nullam vel odio ac eros accumsan convallis quis facilisis enim. Maecenas est ligula, ultrices nec gravida sed, varius non metus. Nam lectus massa, aliquam ac dolor sit amet, convallis sagittis nisl. Quisque in justo et ipsum faucibus pharetra. Suspendisse sed arcu ac ligula feugiat cursus. Curabitur viverra ligula ut lorem feugiat porta.");

                WebElement paymentCashMethodCB1 = driver.findElement(By.xpath("//*[@id=\"cachePickup\"]"));
                paymentCashMethodCB1.click();

                WebElement submitRequestBtn1 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
                submitRequestBtn1.click();
                break;

            case 3:
                WebElement requestBtn2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]"));
                requestBtn2.click();

                WebElement titleTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
                titleTxt2.sendKeys(offer3Id);

                Select categoryDD2 = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
                categoryDD2.selectByIndex(9);

                WebElement fromAddressTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
                fromAddressTxt2.sendKeys("Partizanska 10");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fromAddressTxt2.sendKeys(Keys.ARROW_DOWN);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fromAddressTxt2.sendKeys(Keys.ENTER);

                WebElement toAddressTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
                toAddressTxt2.sendKeys("Partizanska 20" + Keys.ARROW_DOWN + Keys.ENTER);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toAddressTxt2.sendKeys(Keys.ARROW_DOWN);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toAddressTxt2.sendKeys(Keys.ENTER);

                WebElement pickUpDateCB2 = driver.findElement(By.xpath("//*[@id=\"setPickUpDate\"]"));
                pickUpDateCB2.click();

                WebElement earliestPickUpDateTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[1]/input"));
                earliestPickUpDateTxt2.sendKeys("10.05.2022");

                WebElement latestPickUpDateTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[2]/input"));
                latestPickUpDateTxt2.sendKeys("15.05.2022");

                WebElement deliveryCB2 = driver.findElement(By.xpath("//*[@id=\"setDeliveryUpDate\"]"));
                deliveryCB2.click();

                WebElement earliestDeliveryTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[1]/input"));
                earliestDeliveryTxt2.sendKeys("10.06.2022");

                WebElement latestDeliveryDateTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[2]/input"));
                latestDeliveryDateTxt2.sendKeys("15.06.2022");

                WebElement descriptionTxt2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[2]/textarea"));
                descriptionTxt2.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend, neque faucibus vestibulum venenatis, nisi turpis fermentum sem, sed pulvinar dolor sem vel nulla. Nullam vel odio ac eros accumsan convallis quis facilisis enim. Maecenas est ligula, ultrices nec gravida sed, varius non metus. Nam lectus massa, aliquam ac dolor sit amet, convallis sagittis nisl. Quisque in justo et ipsum faucibus pharetra. Suspendisse sed arcu ac ligula feugiat cursus. Curabitur viverra ligula ut lorem feugiat porta.");

                WebElement paymentCashMethodCB2 = driver.findElement(By.xpath("//*[@id=\"cachePickup\"]"));
                paymentCashMethodCB2.click();

                WebElement submitRequestBtn2 = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
                submitRequestBtn2.click();
                break;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/jhi-alert/div/div/div/div/pre")).getText();
    }

    public static void searchOffer() {
        WebElement fromAddressBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[1]/country-selector/div/div[1]/span"));
        fromAddressBtn.click();
        WebElement fromAddressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[1]/country-selector/div/input[1]"));
        fromAddressTxt.sendKeys("Slovakia");
        fromAddressTxt.sendKeys(Keys.ENTER);

        WebElement toAddressBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[2]/country-selector/div/div[1]/span"));
        toAddressBtn.click();
        WebElement toAddressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[2]/country-selector/div/input[1]"));
        toAddressTxt.sendKeys("Serbia");
        toAddressTxt.sendKeys(Keys.ENTER);

        WebElement insuranceDD = driver.findElement(By.xpath("//*[@id=\"field_y\"]"));
        Select selectCategoryDD = new Select(insuranceDD);
        selectCategoryDD.selectByIndex(10);


        WebElement searchBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[3]/a/span[2]"));
        searchBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String sendOffer() {
        WebElement offerBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[2]/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"));
        offerBtn.click();

        WebElement makeOfferBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div/div/button"));
        makeOfferBtn.click();

        WebElement priceTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[2]/div[2]/table/tbody/tr/td[5]/input"));
        priceTxt.sendKeys("50");

        WebElement pickUpTimeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[1]/input"));
        pickUpTimeTxt.sendKeys("10.12.2023 10:00");

        WebElement deliveryTimeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[2]/input"));
        deliveryTimeTxt.sendKeys("12.12.2023 10:00");

        WebElement validUntillTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[3]/input"));
        validUntillTxt.sendKeys("09.12.2022 10:00");

        WebElement insuranceDD = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[4]/select"));
        Select categoryDD = new Select(insuranceDD);
        categoryDD.selectByIndex(1);

        WebElement messageTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[2]/div/textarea"));
        messageTxt.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend, neque faucibus vestibulum venenatis");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        WebElement makeAnOfferBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[5]/button"));
        makeAnOfferBtn.click();

        WebElement submitOfferBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
        submitOfferBtn.click();

        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div/div/button[1]")).getText();
    }

    public static String acceptOffer() {
        WebElement myOffersBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"));
        myOffersBtn.click();

        WebElement moreBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[2]/div/div[8]/a"));
        moreBtn.click();

        WebElement offerBtn = driver.findElement(By.xpath("//*[@id=\"offer0\"]"));
        offerBtn.click();


        WebElement acceptOfferBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[2]/div/div[10]/div/div/div/div[1]/div[2]/div[6]/input"));
        acceptOfferBtn.click();

        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr/td[7]/div/span/span[4]")).getText();
    }

}
