package Utils;

import Driver.Web;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void executeUnixCommand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            printUnixResults(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printUnixResults(Process p) {
        try {
            int result = p.waitFor();
            System.out.println("Process exit code: " + result);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }




}
