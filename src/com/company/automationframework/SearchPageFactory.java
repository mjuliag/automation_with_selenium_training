package com.company.automationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {

    WebDriver driver;

    @FindBy(id = "tab-flight-tab-hp")
    WebElement flightsTab;

    @FindBy(id = "flight-origin-hp-flight")
    WebElement originCity;

    @FindBy(id = "flight-destination-hp-flight")
    WebElement destinationCity;

    @FindBy(id = "flight-departing-hp-flight")
    WebElement departureDate;

    @FindBy(id = "flight-returning-hp-flight")
    WebElement returnDate;

    public SearchPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFlightsTab() {
        flightsTab.click();
    }

    public void setOriginCity(String origin) {
        originCity.sendKeys(origin);
    }

    public void setDestinationCity(String destination) {
        destinationCity.sendKeys(destination);
    }

    public void setDepartureDate(String dateOfDeparture) {
        departureDate.sendKeys(dateOfDeparture);
    }

    public void setReturnDate(String dateOfReturn) {
        returnDate.sendKeys(dateOfReturn);
    }
}
