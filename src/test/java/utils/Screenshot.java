package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    String homePath = System.getenv("HOME");

    public Screenshot(){
    }

    public static String captureScreenshot(WebDriver wdriver, String screenShotName){

        String logFilename = (new SimpleDateFormat("yyyyMMddHHmmsss")).format(new Date());

        try {
            File source = ((TakesScreenshot) wdriver).getScreenshotAs(OutputType.FILE);
            String dest = "." + File.separator + "screenshots" + File.separator + "screenshot_" + screenShotName + "_" + logFilename + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source,destination);

            return dest;
        }
        catch (IOException ioException)
        {
//            Log.error(ioException.getMessage());
            return ioException.getMessage();
        }
    }


}
