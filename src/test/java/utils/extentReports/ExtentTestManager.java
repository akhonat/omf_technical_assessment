package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extentReports = ExtentManager.getExtentReports();

    public static synchronized ExtentTest getTest(){
        return extentTestMap.get((int)Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String description){
        ExtentTest extentTest = extentReports.createTest(testName, description);
        extentTestMap.put((int)Thread.currentThread().getId(), extentTest);
        return extentTest;
    }
}
