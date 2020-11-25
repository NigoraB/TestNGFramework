package Utils;

import Driver.Web;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Helper {


    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds*1000); // 2x1000 = 2000
        } catch (InterruptedException e) {

        }
    }

    public static void doPrintScreen(String fname) {
        TakesScreenshot ts = (TakesScreenshot)Web.getDriver();

        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Screenshots/"+fname+".png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
