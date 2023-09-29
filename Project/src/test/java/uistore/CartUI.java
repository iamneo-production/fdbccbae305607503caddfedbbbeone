package uistore;

import org.openqa.selenium.By;

public class CartUI {
	
	public static By first_itm = By.xpath("//*[@id=\"maindiv\"]/div[1]/div");
	
	//public static By first_crt = By.xpath("//*[@id=\"p_breadcrumb\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/div[1]/div");
	public static By first_crt = By.xpath("(//span[contains(text(),'ADD TO CART')])[1]");
	public static By cart_icon = By.xpath("//span[@class='bucket']");
	public static By delivery_text = By.xpath("//span[contains(text(),'Delivery Pincode:')]");
	
}


