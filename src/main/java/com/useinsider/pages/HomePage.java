package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By languageDropdown = By.id("lang-dropdown");
    private By companyMenu = By.xpath("//nav//a[contains(text(),'Company')]");
    private By careersLink = By.xpath("//a[contains(text(),'Careers')]");

    public HomePage (WebDriver driver) {
        super(driver);
    }


    public boolean isLanguageDropdownDisplayed () {
        return isDisplayed(languageDropdown);

    }

    public void clickCompanyMenu() {
        clickLocator(companyMenu);
    }

    public CareersPage clickCareersLink() {
        clickCompanyMenu();
        clickLocator(careersLink);

        return new CareersPage(driver);
    }


}
