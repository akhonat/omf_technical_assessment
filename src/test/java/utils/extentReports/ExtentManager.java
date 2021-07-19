package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports getExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("OMF Automation Testing Remote Technical Assessment");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Personal Loans", "Calculate Repayment");
        extentReports.setSystemInfo("Author: ", "Akhona Tenge");

        return extentReports;
    }
}
