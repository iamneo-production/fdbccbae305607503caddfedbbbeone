
package pages;

import java.util.Map;
import org.apache.log4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import uistore.ToysUI;
import utils.Base;
import utils.ExcelReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
import utils.LoggerHandler; // Import LoggerHandler
import utils.ReadPropertyFile;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;



public class ToysPage extends Base {

    private Map<String, String> testData;
    private final static Logger logger = Logger.getLogger(ToysPage.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private ExcelReader file = new ExcelReader();
    private ExtentTest test = reporter.createTest("Firstcry_Toys", "Assert Toy's page");

    public void toys_search() {
        try {
            String xl = file.ReadData("./testdata/Testdata.xlsx", "Productslist", 1, "Products");

            WebDriverHelper.ClickOnElement(ToysUI.ToysPage.search_bar);
            logger.info("Clicked Searchbar");
            test.log(Status.PASS,"Clicked searbar");
            WebDriverHelper.sendKeys(ToysUI.ToysPage.search_bar, xl);
            logger.info("Value passed: " + xl);
            test.log(Status.PASS,"Values passed");

            WebDriverHelper.enter_action(ToysUI.ToysPage.search_bar);
            logger.info("Performed Enter action");
            test.log(Status.PASS,"Enter Action Performed");
            
            String title = driver.getCurrentUrl();
            String kword = "kids-toys";
            assert title.contains(kword) : "The URL does not contain the keyword '" + kword + "'";
            logger.info("Assert Successfull");
            test.log(Status.PASS,"Assert Successfull");
            
            Screenshot.getScreenShot(driver, "Toys Page");

            
            // All levels of logs start 
            
            
            logger.info("My Info Log");
            logger.warn("My Warn Log");
            logger.error("My error log");
            logger.fatal("My fatal log");
            logger.debug("debug message");
            logger.trace("Trace message");
           
             
            //All levels of logs start 
            
        } catch (Exception e) {
            logger.error("Exception occurred while performing toy search: " + e.getMessage(), e);
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Toy Search Error");
            test.fail("Failed to perform toy search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
}



