package test.project.pageobjects.itau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.project.infra.selenium.WebElementHelper;

public class Password extends WebElementHelper {

    /**
     * Web Driver reference.
     */
    protected WebDriver driver;

    /**
     * Reference to error message displayed in the password page.
     */
    private final By errorMessageRef = By.cssSelector("div.box-info-erro p[title]");

    /**
     * Reference to password field from HTML page.
     */
    private final By passwordFieldRef = By.cssSelector("#senha");

    /**
     * Class constructor.
     *
     * @param driver Web driver reference.
     */
    public Password(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Validate if the password was properly loaded based on the password field.
     * If the password field is displayed in the page, then the page was properly loaded.
     *
     * @return True if the page was loaded as expected. Otherwise, false.
     */
    public boolean isPasswordPageAvailable() {
        return driver.findElement(passwordFieldRef).isDisplayed();
    }

    /**
     * Get error message test from the box.
     *
     * @return Error message displayed in the screen.
     */
    public String getErrorMessage() {
        return getVisibleWebElement(driver, errorMessageRef).getText();
    }
}
