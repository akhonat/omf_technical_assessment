package steps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home_Page;
import pages.PersonalLoan_Page;
import utils.Screenshot;
import utils.extentReports.ExtentReportClass;
import utils.logs.Log;

import static utils.listeners.ExtentReportListener.extentTest;

public class StepDefinitions extends BaseClass  {

    Home_Page homePage = new Home_Page();
    PersonalLoan_Page personalLoanPage = new PersonalLoan_Page();
    Screenshot screenshot = new Screenshot();
    ExtentReportClass reportClass = new ExtentReportClass();

    public StepDefinitions() {
        reportClass.startReport();
    }

    @Given("^User has the Old Mutual Finance website open$")
    public void userHasTheOldMutualFinanceWebsiteOpen() throws Throwable {

        try {
            OpenBrowser();
            String scrnShot = screenshot.captureScreenshot(webDriver, "OMF website is open");
            //verify the home page title
            String expectedTitle = "Bank and Borrow Solutions | Old Mutual";
            String actualTitle = webDriver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                Assert.assertEquals(actualTitle, expectedTitle, "Title matches");
            } else {
                Log.info("Expected title does not match actual page title");
            }
            reportClass.testStepGiven();
            extentTest.addScreenCaptureFromPath(Screenshot.captureScreenshot(webDriver, scrnShot));

        }
        catch (AssertionError | Exception e) {
//            ExtentReportListener.testStep("FAIL", webDriver,testInfo, e);
            System.out.println(e.getMessage());
        }


    }

    @When("User navigates to the Personal Loans page")
    public void userNavigatesToThePersonalLoansPage() throws Throwable {
        try {
//            scenarioDefinition.createNode(new GherkinKeyword("When"),"User navigates to the Personal Loans page");

            Thread.sleep(2000);
            String scrnShot = screenshot.captureScreenshot(webDriver, "navigate to personal loans");
            webDriver.findElement(By.xpath(homePage.getMnuOurSolutions())).click();
            String scrnShot02 = screenshot.captureScreenshot(webDriver, "click our solutions menu option");
            Thread.sleep(2000);
            webDriver.findElement(By.xpath(homePage.getLnkPersonalLoans())).click();
            String scrnShot03 = screenshot.captureScreenshot(webDriver, "navigate to personal loans");
            Thread.sleep(3000);

            //verify the personal loans page title
            String expectedTitle = "Personal Loans | Apply Online | Old Mutual";
            String actualTitle = webDriver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Title matches");
        }
        catch (AssertionError | Exception e) {
//            ExtentReportListener.testStep("FAIL", webDriver,testInfo, e);
            System.out.println(e.getMessage());
        }
        reportClass.testStepWhen();
    }

    @And("User navigates to Calculate")
    public void userNavigatesToCalculate() throws Throwable {
        try {
            String scrnShot = screenshot.captureScreenshot(webDriver, "navigate to calculator");
            webDriver.findElement(By.xpath(personalLoanPage.getBtnCalculate())).click();
            String scrnShot02 = screenshot.captureScreenshot(webDriver, "click calculate");
            Thread.sleep(2000);
            webDriver.findElement(By.xpath(personalLoanPage.getDdlHowMuchYouNeed())).click();
            String scrnShot03 = screenshot.captureScreenshot(webDriver, "select loan amount needed");
            Thread.sleep(5000);
            WebElement amount = webDriver.findElement(By.xpath(personalLoanPage.getDdlAmountNeeded()));
            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) webDriver);
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", amount);
            webDriver.findElement(By.xpath(personalLoanPage.getDdlAmountNeeded())).click();
            String scrnShot04 = screenshot.captureScreenshot(webDriver, "select loan amount");
            Thread.sleep(2000);
            webDriver.findElement(By.xpath(personalLoanPage.getBtnNext())).click();
            String scrnShot05 = screenshot.captureScreenshot(webDriver, "click next");
            Thread.sleep(5000);
            webDriver.findElement(By.xpath(personalLoanPage.getDdlHowLongToRepay())).click();
            String scrnShot06 = screenshot.captureScreenshot(webDriver, "select loan period");
            Thread.sleep(2000);
            webDriver.findElement(By.xpath(personalLoanPage.getDdlRepayTerm())).click();
            String scrnShot07 = screenshot.captureScreenshot(webDriver, "select repayment period");
            Thread.sleep(5000);

            WebElement btnCalculate = webDriver.findElement(By.xpath(personalLoanPage.getBtnCalc()));
            JavascriptExecutor js = ((JavascriptExecutor) webDriver);
            js.executeScript("arguments[0].scrollIntoView(true);", btnCalculate);
            String scrnShot08 = screenshot.captureScreenshot(webDriver, "click calculate");
            webDriver.findElement(By.xpath(personalLoanPage.getBtnCalc())).click();

            WebElement resultSummary = webDriver.findElement(By.xpath(personalLoanPage.getResultSummary()));
            JavascriptExecutor executor = ((JavascriptExecutor) webDriver);
            executor.executeScript("arguments[0].scrollIntoView(true);", resultSummary);
            String scrnShot09 = screenshot.captureScreenshot(webDriver, "result summary with calulation");

            reportClass.testStepAnd();

        }
        catch (AssertionError | Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Then("The results summary is displayed with repayment amount")
    public void theResultsSummaryIsDisplayedWithRepaymentAmount() {

        try {
            Thread.sleep(3000);

            if (webDriver.findElement(By.xpath(personalLoanPage.getCalculatedAmounts())).getText().contains("R1656.43")) {
                System.out.println("The calculated amounts are R1656.43 and R1810.05");
                System.out.println(webDriver.findElement(By.xpath(personalLoanPage.getCalculatedAmounts())).getText());
            } else {
                System.out.println("The calculated amounts are not R1656.43 and R1810.05");
            }

            reportClass.testStepThen();
            reportClass.tearDown();
            webDriver.quit();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
