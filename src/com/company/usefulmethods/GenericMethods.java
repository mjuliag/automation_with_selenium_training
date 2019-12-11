package com.company.usefulmethods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* In this class we don't comment that a non-existent element was found when we use the getElementList method
like we did in the GenericMethodsPreRefactor class
 */
public class GenericMethods {
    static WebDriver driver;

    public GenericMethods(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            System.out.println("Element found with id: " + locator);
            return this.driver.findElement(By.id(locator));
        } else if (type.equals("name")) {
            System.out.println("Element found with name: " + locator);
            return this.driver.findElement(By.name(locator));
        } else if (type.equals("xpath")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        } else if (type.equals("css")) {
            System.out.println("Element found with css: " + locator);
            return this.driver.findElement(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            System.out.println("Element found with classname: " + locator);
            return this.driver.findElement(By.className(locator));
        } else if (type.equals("tagname")) {
            System.out.println("Element found with tagname: " + locator);
            return this.driver.findElement(By.tagName(locator));
        } else if (type.equals("linktext")) {
            System.out.println("Element found with link text: " + locator);
            return this.driver.findElement(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            System.out.println("Element found with partial link text: " + locator);
            return this.driver.findElement(By.partialLinkText(locator));
        } else {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (type.equals("id")) {
            elementList = this.driver.findElements(By.id(locator));
        } else if (type.equals("name")) {
            elementList = this.driver.findElements(By.name(locator));
        } else if (type.equals("xpath")) {
            elementList = this.driver.findElements(By.xpath(locator));
        } else if (type.equals("css")) {
            elementList = this.driver.findElements(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            elementList = this.driver.findElements(By.className(locator));
        } else if (type.equals("tagname")) {
            elementList = this.driver.findElements(By.tagName(locator));
        } else if (type.equals("linktext")) {
            elementList = this.driver.findElements(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        } else {
            System.out.println("Locator type not supported");
        }
        if (elementList.isEmpty()) {
            System.out.println("Element not found with " + type + ": " + locator);

        } else {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public boolean isElementPresent(String locator, String type) {
        List<WebElement> elementList = getElementList(locator, type);

        int size = elementList.size();

        if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element appeared on the web page");
        } catch (Exception e) {
            System.out.println("Element not appeared on the web page");
        }
        return element;
    }

    public void clickWhenReady(By locator, int timeout) {
        try {
            WebElement element = null;
            System.out.println("Waiting for max: " + timeout + " seconds for element to be clickable");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Element clicked");
        } catch (Exception e) {
            System.out.println("Element not appeared on the web page");
        }
    }

    public String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public void takeScreenshot() throws IOException {
        String fileName = getRandomString(10) + ".jpg";
        String newDirectory = "C:\\Users\\JuliaGirona\\Desktop\\";

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(newDirectory + fileName);

        Path path = Files.copy(sourceFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        if (Files.exists(path)) {
            System.out.println("File copied succesfully to " + destination);
        } else {
            System.out.println("Unable to copy file :(");
        }
    }

    //This method uses FileUtils from Apache Commons library
    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "C:\\Users\\JuliaGirona\\Desktop\\";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        String destination = directory + fileName;
        return destination;
    }
}
