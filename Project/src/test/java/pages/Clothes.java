package pages;

import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import uistore.ToysUI;
import uistore.ClothesUI;
import utils.Base;
import utils.ExcelReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
import utils.LoggerHandler;
import utils.ReadPropertyFile;
import com.aventstack.extentreports.Status;

public class Clothes extends Base {

    private Map<String, String> testData;
    private final static Logger logger = Logger.getLogger(Clothes.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private ExcelReader file = new ExcelReader();
    private ExtentTest test = reporter.createTest("Firstcry_Clothes", "Assert CLothes page");

    public void cloth_search() {
        try {
            String xl = file.ReadData("./testdata/Testdata.xlsx", "Productslist", 2, "Products");

            WebDriverHelper.ClickOnElement(ToysUI.ToysPage.search_bar);
            logger.info("Clicked Searchbar");
            test.log(Status.PASS,"Clicked searbar");

            WebDriverHelper.sendKeys(ToysUI.ToysPage.search_bar, xl);
            logger.info("Value passed: " + xl);
            test.log(Status.PASS,"Values passed");
            
            WebDriverHelper.enter_action(ToysUI.ToysPage.search_bar);
            logger.info("Performed Enter action");
            test.log(Status.PASS,"Enter Action Performed");
            
            WebDriverHelper.ClickOnElement(ClothesUI.ethnic_checkbox);
            logger.info("Ehnic Checkbox selected");
            test.log(Status.PASS,"Clicked Ethnic Checkbox");
            
            WebElement check = driver.findElement(ClothesUI.ethnic_header);
            String Keyword = "Ethnic Wear";
            	String gettext = check.getText();
            	assert gettext.contains(Keyword): "The element text does not contain the keyword '" + Keyword + "'";
            	
            	logger.info("Asserted Etnic Wear");
            	test.log(Status.PASS,"Assert Successfull");

            
        } catch (Exception e) {
        	logger.error("Exception occurred while performing clothes search: " + e.getMessage(), e);
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Clothes Search Error");
            test.fail("Failed to perform Clothes search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
}

