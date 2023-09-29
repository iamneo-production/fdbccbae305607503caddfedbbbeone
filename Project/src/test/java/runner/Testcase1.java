
package runner;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import pages.ToysPage;
import utils.Base;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utils.LoggerHandler;
import utils.Reporter;

public class Testcase1 extends Base {
	
    private ExtentReports reporter;
    private ToysPage Tpage = new ToysPage();
    
    @Test(priority = 1)
    public void toyspg() throws IOException, InvalidFormatException {
        Tpage.toys_search();  
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

