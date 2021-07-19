package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Screenshot;
import utils.logs.Log;

import java.io.*;
import java.util.Properties;


public class BaseClass {

    public static WebDriver webDriver;
    public String osName = "";
    public String projectLocation;
    Screenshot screenshot = new Screenshot();
    private static final String WEBDRIVERCHROME = "webdriver.chrome.driver";
    private static final String WEBDRIVERFIREFOX = "webdriver.gecko.driver";
    private static final String driverBase = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers" + File.separator;
    Properties properties = new Properties();
    public ExtentReports extentReports;
    public static ExtentTest scenarioDefinition;
    public static ExtentTest feature;


    /** create properties file object for use in class */
    public BaseClass(){

        InputStream inputStream;
        try{
            //load a properties file
            projectLocation = System.getProperty("user.dir");
            osName = System.getProperty("os.name");
            System.out.println(projectLocation + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
            inputStream = new FileInputStream(projectLocation + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
            properties.load(inputStream);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            Log.error("File not found.");
        }
        catch (IOException ioException)
        {
            Log.error("IO Exception");
        }

    }
    /** open web browser - Google Chrome or Mozilla Firefox */
    public void OpenBrowser() throws Throwable{
        String browserName;
        String browserHeadless;

        browserName = properties.getProperty("browser.name");
        browserHeadless = properties.getProperty("browser.headless");

       String url = "https://www.oldmutualfinance.co.za/";

        //******** code for Google Chrome ********/

        if(browserName.equals("GC")){
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            if(browserHeadless.equals("true")){
                options.addArguments("headless");
                options.addArguments("window-size=1200,1100");
            }

            if(osName.equalsIgnoreCase("Mac OS X")){
                System.setProperty(WEBDRIVERCHROME, driverBase + "chromedriver");
                webDriver = new ChromeDriver(options);
                webDriver.get(url);
                Dimension dimension = new Dimension(1400, 2000);
                webDriver.manage().window().setSize(dimension);
            }
            else {
                System.setProperty(WEBDRIVERCHROME, driverBase + "chromedriver.exe");
                webDriver = new ChromeDriver(options);
                Thread.sleep(5000);
                webDriver.get(url);
                webDriver.manage().window().maximize();
            }
        }

        //******** code for Mozilla Firefox *******/

        if(browserName.equals("MF")){

            if(osName.equalsIgnoreCase("Mac OS X")){
                System.setProperty(WEBDRIVERFIREFOX, driverBase + "geckodriver.exe");
                webDriver = new FirefoxDriver();
                webDriver.get(url);
                Dimension dimension = new Dimension(1400, 2000);
                webDriver.manage().window().setSize(dimension);
            }
            else {
                System.setProperty(WEBDRIVERFIREFOX, driverBase + "geckodriver.exe");
                webDriver = new FirefoxDriver();
                Thread.sleep(5000);
                webDriver.get(url);
                webDriver.manage().window().maximize();
            }
        }

    }

}
