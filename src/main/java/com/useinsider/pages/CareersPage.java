package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    public CareersPage (WebDriver driver) {
        super(driver);
    }
    private By locationsBlock = By.xpath("//*[@class='category-title-media ml-0']");
    private By teamsBlock = By.xpath("(//*[@class='category-title-media'])[1]");
    private By lifeAtInsiderBlock = By.xpath("(//*[@class='elementor-heading-title elementor-size-default'])[last()]");

    public boolean isCareersPageLoaded() {
        return isDisplayed(locationsBlock) && isDisplayed(teamsBlock) && isDisplayed(lifeAtInsiderBlock);
    }

}
