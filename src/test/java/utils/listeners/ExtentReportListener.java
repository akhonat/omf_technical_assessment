package utils.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.logs.Log;

import java.io.IOException;

public interface ExtentReportListener {

    ExtentSparkReporter sparkReporter = null;
    ExtentReports extentReports = null;
    ExtentTest extentTest = null;

     default ExtentReports setUp(){
        try {
            String reportLocation = "./extent-reports/omf_automation_report.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportLocation);
            sparkReporter.loadXMLConfig("./src/test/resources/extent-config.xml");
            ExtentReports extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Website","Old Mutual Finance");
            extentReports.setSystemInfo("Personal Loans", "Calculate Repayment");
            extentReports.setSystemInfo("Author: ", "Akhona Tenge");

        }
        catch (IOException ioException)
        {
            Log.error(ioException.getMessage());
        }
        return extentReports;
    }

//    static void testStep(String testStatus, WebDriver driver, ExtentTest test, Throwable throwable){
//        switch(testStatus) {
//            case "FAIL":
//                test.fail(MarkupHelper.createLabel("Test case has Failed: ", ExtentColor.RED));
//                test.fail(throwable.fillInStackTrace());
//
//                if (driver != null) {
//                    driver.quit();
//                }
//                break;
//
//            case "PASS":
//                test.pass(MarkupHelper.createLabel("Test case is Passed: ", ExtentColor.GREEN));
//                break;
//
//            default:
//                break;
//        }
//    }



}
