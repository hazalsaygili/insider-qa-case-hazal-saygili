package com.useinsider;

import com.useinsider.pages.QAJobsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class QAJobsPageTest extends BaseTest {
    @Test
    public void testQAJobsPageLoaded (){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQaJobsUrl();

        assertTrue(qaJobsPage.isQaJobsPageLoaded(), "QA Jobs Page is not loaded.");

    }

    @Test
    public void testLocationFilterIstanbulOption(){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQaJobsUrl();
        qaJobsPage.clickSeeAllQaJobsButton();
        qaJobsPage.clickIstanbulOption();
        assertTrue(qaJobsPage.checkJobListExists(), "Job list does not exist.");
        assertTrue(qaJobsPage.verifyJobDetails("Quality Assurance", "QA", "Quality Assurance", "Istanbul, Turkey"), "Job details don't match with filter");

    }

    @Test
    public void testViewRoleToLeverPage () {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQaJobsUrl();
        qaJobsPage.clickSeeAllQaJobsButton();
        qaJobsPage.clickIstanbulOption();
        qaJobsPage.clickViewRole();
        String newUrl = qaJobsPage.getUrlOfNewTab();
        assertTrue(newUrl.contains("lever.co"), "The current URL does not contain 'lever.co'.");

    }


}
