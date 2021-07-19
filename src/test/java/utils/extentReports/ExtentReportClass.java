package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import steps.BaseClass;


public class ExtentReportClass extends BaseClass{

    //build new report using spark template
    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public void startReport(){
        try {
            //initialize the SparkReporter
            sparkReporter = new ExtentSparkReporter("./extent-reports/omf_automation_report.html");
            sparkReporter.loadXMLConfig("src/test/resources/extent-config.xml");

            //initialize ExtentReports and attach SparkReporter
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentTest = extentReports.createTest(Feature.class, "Feature: Calculate Personal Loan Repayment");
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testStepGiven(){
        extentTest.createNode(Given.class, "User has the Old Mutual Finance website open");

        Assert.assertTrue(true);
        extentTest.log(Status.INFO, "Test started");
    }
    @Test
    public void testStepWhen(){
        extentTest.createNode(When.class, "User navigates to the Personal Loans page");
        Assert.assertTrue(true);
        extentTest.pass("Navigated to Personal Loan page");
    }
    @Test
    public void testStepAnd(){
        extentTest.createNode(And.class, "User navigates to Calculator");
        Assert.assertTrue(true);
        extentTest.pass("Navigated to Personal Loan Calculator");
    }
    @Test
    public void testStepThen(){
        extentTest.createNode(Then.class, "The results summary is displayed with repayment amount");
        Assert.assertTrue(true);
        extentTest.pass("The results summary is displayed with repayment amount");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearDown() {
        extentReports.flush();
    }

}

