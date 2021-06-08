package test.project.pageobjects.itau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.project.infra.selenium.WebElementHelper;

public class SignIn extends WebElementHelper {

    /**
     * Web Driver reference.
     */
    protected WebDriver driver;

    private static final String SIGN_IN_URL = "https://www.itau.com.br/";

    /**
     * Reference to agency field from HTML page.
     */
    private final By agencyFieldRef = By.cssSelector("#agencia");

    /**
     * Reference to account number field from HTML page.
     */
    private final By accountFieldRef = By.cssSelector("#conta");

    /**
     * Reference to login button from HTML page.
     */
    private final By loginButtonRef = By.cssSelector("#btnLoginSubmit");

    /**
     * Class constructor.
     *
     * @param driver Web driver reference.
     */
    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigate to Sign In URL.
     */
    public void open() {
        driver.get(SIGN_IN_URL);
    }

    /**
     * Fill agency number.
     *
     * @param agency Agency number.
     */
    public void fillAgencyField(String agency) {
        getVisibleWebElement(driver, agencyFieldRef).sendKeys(agency);
    }

    /**
     * Fill account number.
     *
     * @param account Account number of the user.
     */
    public void fillAccountField(String account) {
        getVisibleWebElement(driver, accountFieldRef).sendKeys(account);
    }

    /**
     * Perform a Sign In flow based on the agency and account provided.
     *
     * @param agency  Agency number.
     * @param account Account number of the user.
     */
    public void signInUser(String agency, String account) {
        getVisibleWebElement(driver, agencyFieldRef).sendKeys(agency);
        getVisibleWebElement(driver, accountFieldRef).sendKeys(account);
    }

    /**
     * Perform a Sign In flow based on the agency and account previously provided.
     *
     * @return Reference to the next page opened.
     */
    public Password clickLoginButton() {
        getClickableWebElement(driver, loginButtonRef).click();
        return new Password(this.driver);
    }

    /**
     * Verifies if the login button in the Sign In page is enabble/disabled.
     *
     * @return True if the button is enabled. Otherwise, false.
     */
    public boolean isLoginButtonEnable() {
        return getVisibleWebElement(driver, loginButtonRef).isEnabled();
    }
}
