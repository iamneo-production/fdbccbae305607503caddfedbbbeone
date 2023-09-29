package pages;

import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uistore.ToysUI;
import uistore.ClothesUI;
import uistore.CartUI;
import utils.Base;
import utils.ExcelReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class Cart extends Base {

	
  

	private Map<String, String> testData;
	private final static Logger logger = Logger.getLogger(Cart.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private ExcelReader file = new ExcelReader();
    private ExtentTest test = reporter.createTest("Add to Cart", "Assert Cart page");
    
    

    public void cart_verify() {
        try {
            String xl = file.ReadData("./testdata/Testdata.xlsx", "Productslist", 3, "Products");

            WebDriverHelper.ClickOnElement(ToysUI.ToysPage.search_bar);
            logger.info("Clicked Searchbar");
            test.log(Status.PASS,"Clicked searbar");
            
            WebDriverHelper.sendKeys(ToysUI.ToysPage.search_bar, xl);
            logger.info("Value passed: " + xl);
            test.log(Status.PASS,"Value Passed");

            WebDriverHelper.enter_action(ToysUI.ToysPage.search_bar);
            logger.info("Performed Enter action");
            test.log(Status.PASS,"Enter Action Performed");
            
            WebDriverHelper.ClickOnElement(CartUI.first_itm);
            logger.info("Clicked 1st Item");
            test.log(Status.PASS,"Clicked First Item");
            
            try {
				WebDriverHelper.switchToNewWindow();
				 WebDriverHelper.ClickOnElement(CartUI.first_crt);
		            logger.info("Clicked 1st Item Add to cart");
		            test.log(Status.PASS,"Clicked Add to Cart");
		            
		            WebDriverHelper.ClickOnElement(CartUI.cart_icon);
		            logger.info("Clicked Cart");
		            test.log(Status.PASS,"Clicked Cart");

		            WebElement check = driver.findElement(CartUI.delivery_text);
		        	String Keyword = "Delivery Pincode:";
		        	String gettext = check.getText();
		        	assert gettext.contains(Keyword): "The cart page text does not contain the keyword '" + Keyword + "'";
		        	 logger.info("Asserted delivery text");
		        	 test.log(Status.PASS,"Asser Successfully");
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error("Exception occurred while performing Add To Cart: " + e.getMessage());
				e.printStackTrace();
				String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Cart page Error");
				test.fail("Failed to perform Add To Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
			}
            
           
            
        } catch (Exception e) {
           // logger.error("Exception occurred while performing Add To Cart: " + e.getMessage());
            e.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Cart page Error");
            test.fail("Failed to perform Add To Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
}

