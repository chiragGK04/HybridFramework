package com.testscripts.demoblaze;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Baseclass;
import com.genericlib.demoblaze.Eventlist;

@Listeners(Eventlist.class)
public class Addtocart extends Baseclass
{
	@Test
	public void addtocartTest() throws IOException, InterruptedException
	{
		test=extent.createTest("add to cart report");
		
		test.pass("logged in");
		cu.productname(driver,fl.getdatafromproperties(propath, "productname")).click();
		test.pass("navigated to product details page");
		hp.getAddtocart().click();
		test.pass("product added to cart");
		cu.waitfortheAlert(driver);
		cu.accepAlert(driver);
		test.pass("allert has been handled");
		hp.getCart().click();
		test.pass("navigated to cart page");
		WebElement productcart = cu.findproductinthecart(driver, fl.getdatafromproperties(propath, "productname"));
		Assert.assertTrue(productcart.isDisplayed());
		test.pass("product has been verified");
		hp.getCartdeleteproduct().click();
		Thread.sleep(2000);
		try 
		{
			cu.findproductinthecart(driver, fl.getdatafromproperties(propath, "productname")).isDisplayed();
			Assert.assertTrue(false);
		}
		catch (NoSuchElementException n) 
		{
			
			System.out.println("Test case passes");
		}
		test.pass("product has been removed from cart");
		
		
		
		
	}

}
 