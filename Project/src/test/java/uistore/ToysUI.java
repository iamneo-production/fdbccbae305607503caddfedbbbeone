package uistore;

import org.openqa.selenium.By;

public class ToysUI {

    public static class ToysPage {
        public static By search_bar = By.id("search_box");
        public static By toy_header = By.xpath("//div/h1[contains(text(),'Kids Toys')]");
    }
}
