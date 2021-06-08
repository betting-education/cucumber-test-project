package test.project.infra.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementHelper {

    /**
     * Logger reference.
     */
    private static final Logger LOGGER = LogManager.getLogger(WebElementHelper.class.getName());
    /**
     * Wait (in seconds) WebElement to be available and visible in the page.
     */
    private static final int DEFAULT_TIMEOUT_WAIT_ELEMENT = 180;

    /**
     * Get visible HTML element from the page. Explicitly wait for {@link WebElementHelper#DEFAULT_TIMEOUT_WAIT_ELEMENT}
     * seconds before fails the execution.
     *
     * @param driver     Remote WebDriver reference.
     * @param identifier Identifier (html) reference.
     * @return Reference to identifier as WebElement.
     */
    protected WebElement getVisibleWebElement(WebDriver driver, By identifier) {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT_WAIT_ELEMENT)
                .withMessage(() -> {
                    final String errorMessage = String
                            .format("Could not find the element with identifier: '%s'. Current URL: '%s'.",
                                    identifier.toString(), driver.getCurrentUrl());
                    LOGGER.error(errorMessage);
                    return errorMessage;
                })
                .until(ExpectedConditions.visibilityOfElementLocated(identifier));
    }

    /**
     * Get clickable HTML element from the page. Explicitly wait for
     * {@link WebElementHelper#DEFAULT_TIMEOUT_WAIT_ELEMENT} seconds before fails the execution.
     *
     * @param driver     Remote WebDriver reference.
     * @param identifier Identifier (html) reference.
     * @return Reference to identifier as WebElement.
     */
    protected WebElement getClickableWebElement(WebDriver driver, By identifier) {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT_WAIT_ELEMENT)
                .withMessage(() -> {
                    final String errorMessage = String
                            .format("Could not find the element with identifier: '%s'. Current URL: '%s'.",
                                    identifier.toString(), driver.getCurrentUrl());
                    LOGGER.error(errorMessage);
                    return errorMessage;
                })
                .until(ExpectedConditions.elementToBeClickable(identifier));
    }
}
