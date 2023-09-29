package runner;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import pages.Clothes;
import pages.ToysPage;
import utils.Base;
import utils.Reporter;
import uistore.ToysUI;
import uistore.ClothesUI;

public class Testcase2 extends Base {
	

    private ExtentReports reporter = Reporter.generateExtentReport();
    private ToysPage Tpage = new ToysPage();
    private Clothes Clothpage = new Clothes();
    private ClothesUI Clothui = new ClothesUI();
    
    
    
    @Test(priority = 2)
    public void clothpg() throws IOException, InvalidFormatException{
    	Clothpage.cloth_search();  	
    }

@BeforeMethod
public void beforeMethod() throws MalformedURLException {
    openBrowser();
    reporter = Reporter.generateExtentReport();
}

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        reporter.flush();
      
    }
}

