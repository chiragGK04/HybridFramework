package com.genericlib.demoblaze;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

public class Commonutils 
{
	WebDriverWait wait;
	public WebElement productname(WebDriver driver,String productname)
	{
		return driver.findElement(By.xpath("//a[.='"+productname+"']"));
	}
	
	public WebElement findproductinthecart(WebDriver driver,String productname)
	{
		return driver.findElement(By.xpath("//td[.='"+productname+"']"));
	}
	
	public void waitForTheText(WebDriver driver,WebElement e,String text)
	{
		 wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBePresentInElement(e, text));
	}
	
	public void accepAlert(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public void waitfortheAlert(WebDriver driver)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void waitfortheelementtobeClickable(WebDriver driver,WebElement e)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(e));
		
	}
	//contact
	public void waitforSendmsgClickable(WebDriver driver,WebElement e)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(e));
		
	}
	
	

} 
