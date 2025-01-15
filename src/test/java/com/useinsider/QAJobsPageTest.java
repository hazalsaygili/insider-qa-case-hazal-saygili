package com.useinsider;

import com.useinsider.pages.QAJobsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class QAJobsPageTest extends BaseTest {
    @Test
    public void testQAJobsPageLoaded (){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQaJobsUrl();

        assertTrue(qaJobsPage.isQaJobsPageLoaded());

    }

    @Test
    public void testLocationFilterIstanbulOption(){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQaJobsUrl();
        qaJobsPage.clickSeeAllQaJobsButton();
        qaJobsPage.clickIstanbulOption();
        assertTrue(qaJobsPage.checkJobListExists());
        assertTrue(qaJobsPage.verifyJobDetails("Quality Assurance", "QA", "Quality Assurance", "Istanbul, Turkey"));

    }

    @Test
    public void testViewRoleToLeverPage () {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQaJobsUrl();
        qaJobsPage.clickSeeAllQaJobsButton();
        qaJobsPage.clickIstanbulOption();
        qaJobsPage.clickViewRole();
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("lever.co"), "The current URL does not contain 'lever.co'.");

    }


}
