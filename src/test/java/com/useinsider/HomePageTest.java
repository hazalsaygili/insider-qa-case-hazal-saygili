package com.useinsider;

import com.useinsider.pages.CareersPage;
import com.useinsider.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageIsLoaded () {
        HomePage homePage = new HomePage(driver);

        assertTrue(homePage.isLanguageDropdownDisplayed(),"Home page is not loaded." );

    }

    @Test
    public void testCareersPageLoadedFromNavBar () {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = homePage.clickCareersLink();

        assertTrue(careersPage.isCareersPageLoaded(),"Careers page is not loaded.");
    }
}
