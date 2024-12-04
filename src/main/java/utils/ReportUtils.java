package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {

    private ExtentReports extent;

    private ExtentSparkReporter spark;

    private ExtentTest extentTest;

    public ReportUtils(String reportFilename) throws Exception {

        extent = new ExtentReports();

        spark = new ExtentSparkReporter(reportFilename);

        extent.attachReporter(spark);

    }

    public void createTestcase(String testcasename) throws Exception {

        extentTest = extent.createTest(testcasename);
    }

    public void addLogs(String status, String message) throws Exception {

        switch (status.toLowerCase()) {
            case "info":

                extentTest.log(Status.INFO, message);

                break;

            case "warn":

                extentTest.log(Status.WARNING, message);

                break;
            case "skip":

                extentTest.log(Status.SKIP, message);

                break;

            case "pass":

                extentTest.log(Status.PASS, message);

                break;
            case "fail":

                extentTest.log(Status.FAIL, message);

                break;
            default:
                extentTest.log(Status.FAIL, message);
                break;
        }

    }

    public void addScreenshotToReport(String filename) throws Exception {

        extentTest.addScreenCaptureFromPath(filename);

    }

    public void flushReport() {
        extent.flush();
    }

}
