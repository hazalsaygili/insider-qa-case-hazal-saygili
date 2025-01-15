package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QAJobsPage extends BasePage {

    public QAJobsPage (WebDriver driver) {
        super(driver);
    }

    private String qaJobsUrl = "https://useinsider.com/careers/quality-assurance/";
    private By seeAllQaJobsButton = By.xpath("//*[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']");
    private By locationFilter = By.id("select2-filter-by-location-container");
    private By istanbulOption = By.cssSelector("[id*=\"Istanbul, Turkey\"]");
    private By jobList = By.cssSelector("[class*=\"position-list-item \"]");
    private By jobPosition = By.cssSelector("[class*=\"position-title\"]");
    private By jobDepartment = By.cssSelector("[class*=\"position-department\"]");
    private By jobLocation = By.cssSelector("[class*=\"position-location\"]");
    private By viewRoleButton = By.xpath("(//*[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[1]");

    public void openQaJobsUrl() {
        driver.get(qaJobsUrl);
    }

    public boolean isQaJobsPageLoaded() {
        return isDisplayed(seeAllQaJobsButton);
    }

    public void clickSeeAllQaJobsButton() {
        clickAcceptAllCookies();
        clickLocator(seeAllQaJobsButton);
    }

    public void clickLocationFilter() {
        waitFor(20000);
        clickLocator(locationFilter);
    }

    public void clickIstanbulOption() {
        clickLocationFilter();
        clickLocator(istanbulOption);
        scrollPage();
        waitFor(15000);
    }

    public boolean checkJobListExists() {
        List<WebElement> jobs = findElements(jobList);
        boolean jobsExist = false;

        if(jobs.size() > 0) {
            jobsExist = true;
        }

        return jobsExist;
    }

    public boolean verifyJobDetails(String position1, String position2, String department, String location) {
        List<WebElement> jobs = findElements(jobList);

        for (WebElement job : jobs) {
            String jobPositionText = job.findElement(jobPosition).getText();
            String jobDepartmentText = job.findElement(jobDepartment).getText();
            String jobLocationText = job.findElement(jobLocation).getText();

            if (!(jobPositionText.contains(position1) || jobPositionText.contains(position2)) ||
                    !jobDepartmentText.contains(department) ||
                    !jobLocationText.contains(location)) {
                return false;
            }
        }
        return true;
    }

    public void clickViewRole() {
    clickLocator(viewRoleButton);
    waitFor(10000);
    }

}

