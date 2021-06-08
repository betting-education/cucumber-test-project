package test.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import test.project.pageobjects.itau.Password;
import test.project.pageobjects.itau.SignIn;

public class StepDefinitions {

    /**
     * Logger reference.
     */
    private static final Logger LOGGER = LogManager.getLogger(StepDefinitions.class.getName());

    /**
     * WebDriver reference.
     */
    public static WebDriver driver;

    /**
     * SignIn page object reference.
     */
    private SignIn signInPage;

    /**
     * Password page object reference.
     */
    private Password passwordPage;

    /**
     * Set the environment up before test execution.
     */
    @Before
    public void setUp() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", getDriverPath());
        driver = new ChromeDriver(chromeOptions);
    }

    /**
     * Perform cleanup after each scenario is executed.
     */
    @After
    public void testCleanup() {
        driver.quit();
    }

    /**
     * Build driver path for any platform.
     *
     * @return Full path of local driver.
     */
    private String getDriverPath() {
        final String currentPath = System.getProperty("user.dir");
        return currentPath + "/drivers/chromedriver.exe";
    }

    @Given("I have opened the Itau main page")
    public void openMainPage() {
        LOGGER.info("Open main page");
        signInPage = new SignIn(driver);
        signInPage.open();
    }

    @Then("^I verify login button is \"(enabled|disabled)\"$")
    public void checkLoginButtonStatus(String status) {
        LOGGER.info(String.format("Checking it the login button is '%s'...", status));
        if ("enabled".equals(status)) {
            assertTrue(signInPage.isLoginButtonEnable());
        } else {
            // disabled
            assertFalse(signInPage.isLoginButtonEnable());
        }
    }

    @Then("the error message {string} is displayed")
    public void checkErrorMessage(String errorMessage) {
        LOGGER.info("Validate error message");
        assertEquals(errorMessage, passwordPage.getErrorMessage());
    }

    @When("I provide the agency {string} and the account {string}")
    public void fillAgencyAccountNumbers(String agency, String account) {
        LOGGER.info(String.format("Setting the agency number '%s' and account number '%s' in the form...", agency,
                account));
        signInPage.signInUser(agency, account);
    }

    @When("I provide the agency {string}")
    public void fillAgencyNumber(String agency) {
        LOGGER.info(String.format("Setting the agency number '%s' in the form...", agency));
        signInPage.fillAgencyField(agency);
    }

    @When("I provide the account {string}")
    public void fillAccountNumber(String account) {
        LOGGER.info(String.format("Setting the account number '%s' in the form...", account));
        signInPage.fillAccountField(account);
    }

    @When("I click Login button")
    public void clickLoginButton() {
        LOGGER.info("Click Login button");
        passwordPage = signInPage.clickLoginButton();
    }
}
