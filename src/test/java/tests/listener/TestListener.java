package tests.listener;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import tests.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestListener extends BaseTest implements ITestListener {

  private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  private static ExtentReports EXTENT = createInstance();
  private static ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();
  private static ExtentTest extentClass;

  public static ExtentReports createInstance() {
    String fileName = "Test-Report.html";
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().enableTimeline(false);
    htmlReporter.config().setDocumentTitle("API Test Report");
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName("CAPI Test Report");
    htmlReporter.config().setJS("document.getElementById" + "(\"enable-dashboard\").click()");
    EXTENT = new ExtentReports();
    EXTENT.attachReporter(htmlReporter);
    EXTENT.setAnalysisStrategy(AnalysisStrategy.SUITE);
    return EXTENT;
  }

  @Override
  public synchronized void onStart(ITestContext context) {
    LOGGER.info("Test Suite started - " + context.getCurrentXmlTest().getSuite().getName());
    ExtentTest extentSuite = EXTENT.createTest(context.getCurrentXmlTest().getSuite().getName());
    extentClass = extentSuite.createNode(context.getAllTestMethods()[0].getTestClass().getName());
  }

  @Override
  public synchronized void onFinish(ITestContext context) {
    LOGGER.info(("Test Suite is ending - " + context.getCurrentXmlTest().getSuite().getName()));
    EXTENT.flush();
  }

  @Override
  public synchronized void onTestStart(ITestResult result) {
    LOGGER.info((result.getMethod().getMethodName() + " started."));
    ExtentTest extentTest = extentClass.createNode(result.getMethod().getDescription());
    TEST.set(extentTest);
  }

  @Override
  public synchronized void onTestSuccess(ITestResult result) {
    LOGGER.info((result.getMethod().getMethodName() + " passed."));
    TEST.get().pass("Test passed");
  }

  @Override
  public synchronized void onTestFailure(ITestResult result) {
    LOGGER.info((result.getMethod().getMethodName() + " failed."));
    TEST.get().fail(result.getThrowable());
  }

  @Override
  public synchronized void onTestSkipped(ITestResult result) {
    LOGGER.info((result.getMethod().getMethodName() + " skipped."));
    TEST.get().skip(result.getThrowable());
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    LOGGER.info(
        ("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
  }
}
