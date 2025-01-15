package com.useinsider.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isDisplayed(By locator) {
        boolean isVisible = false;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            isVisible = element.isDisplayed();
        } catch (TimeoutException e) {
            isVisible = false;
        }
        return isVisible;
    }


    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public void clickLocator(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }


    public void clickAcceptAllCookies() {
        clickLocator(By.id("wt-cli-accept-all-btn"));
    }

    public void waitFor (long msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollPage () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
    }


}
