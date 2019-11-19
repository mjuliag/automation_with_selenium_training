package com.company.automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    public static WebElement element = null;

    /**
     * Navigate to flights tab
     * @param driver
     */
    public static void navigateToFlightsTab(WebDriver driver) {
        element = driver.findElement(By.id("tab-flight-tab-hp"));
        element.click();
    }

    /**
     * Returns the flight origin text box element
     * @param driver
     * @return
     */
    public static WebElement originTextBox(WebDriver driver) {
        element = driver.findElement(By.id("package-origin-hp-package"));
        return element;
    }

    public static void fillOriginTextBox(WebDriver driver, String origin) {
        element = originTextBox(driver);
        element.sendKeys(origin);
    }

    /**
     * Returns the flight destination text box element
     * @param driver
     * @return
     */
    public static WebElement destinationTextBox(WebDriver driver) {
        element = driver.findElement(By.id("package-destination-hp-package"));
        return element;
    }

    /**
     * Returns the departure date text box element
     * @param driver
     * @return
     */
    public static WebElement departureDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("package-departing-hp-package"));
        return element;
    }

    /**
     * Returns the return date text box element
     * @param driver
     * @return
     */
    public static WebElement returnDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("package-returning-hp-package"));
        return element;
    }

    /**
     * Returns the search button box element
     * @param driver
     * @return
     */
    public static WebElement searchButton(WebDriver driver) {
        element = driver.findElement(By.id("search-button-hp-package"));
        return element;
    }

    /**
     * Click on search button
     * @param driver
     */
    public static void clickOnSearchButton(WebDriver driver) {
        element = searchButton(driver);
        element.click();
    }

    /**
     * Navigate to flights tab
     * @param driver
     */
    public static void navigateToBundleAndSaveTab(WebDriver driver) {
        element = driver.findElement(By.id("tab-package-tab-hp"));
        element.click();
    }
}
