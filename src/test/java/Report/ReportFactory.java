package Report;

import Utils.Helper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportFactory {

    @BeforeSuite
    public void removeOldReport() {
        Helper.executeUnixCommand("rm -rf allure-results");
        Helper.executeUnixCommand("rm -rf allure-report");
    }

    @AfterSuite
    public void createReport() {
        Helper.executeUnixCommand("allure generate");
        String reportFolder = reportFolderName();
        Helper.executeUnixCommand("mkdir Reports/"+reportFolder);
        Helper.executeUnixCommand("cp -r allure-report/ ./Reports/"+reportFolder+"/");
        Helper.executeUnixCommand("mv ./Reports/"+reportFolder+"/index.html ./Reports/"+reportFolder+"/reportFile.html");
                                        // mv Reports/Dec2_200000/index.html ./Reports/Dec2_200000/reportFile.html
    }

    private String reportFolderName() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMMdd_hhmmss");
        Date now = new Date();
        return df.format(now);
    }


}
