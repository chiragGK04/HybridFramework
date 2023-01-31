package com.genericlib.demoblaze;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.objectrepo.demoblaze.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	public Filelib fl=new Filelib();
	public String propath="src/test/resources/commondata.properties";
	public String propath1="src/test/resources/contactdata.properties";
	
	public  static ExtentReports extent;
	public  static ExtentSparkReporter spark;
	public  static ExtentTest test;
	
	public  static Homepage hp;
	
	public Commonutils cu=new Commonutils();
	
	
	@BeforeSuite
	public void configBSTest() throws IOException
	{
		extent=new ExtentReports();
		spark=new ExtentSparkReporter("extentreport.html");
		extent.attachReporter(spark);
		
		if(fl.getdatafromproperties(propath,"browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		if(fl.getdatafromproperties(propath, "browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(fl.getdatafromproperties(propath, "url"));
	}
	
	@BeforeMethod
	public void configBMTest() throws IOException
	{
		hp=PageFactory.initElements(driver, Homepage.class);
		hp.getLogin().click();
		cu.waitfortheelementtobeClickable(driver, hp.getLoginbutton());
		hp.getUsername().sendKeys(fl.getdatafromproperties(propath, "username"));
		hp.getPassword().sendKeys(fl.getdatafromproperties(propath, "password"));
		hp.getLoginbutton().click();
		cu.waitForTheText(driver, hp.getVerifylogin(),fl.getdatafromproperties(propath, "logintext"));
		Assert.assertTrue(hp.getVerifylogin().getText().contains(fl.getdatafromproperties(propath, "username")));
		
	}
	
	@AfterMethod
	public void configAMTest()
	{
		hp.getLogout().click();
		Assert.assertTrue(hp.getLogin().getText().equals("Log in"));
		test.pass("logged out succesfully");
	}
	
	@AfterSuite
	public void configASTest()
	{
		driver.quit();
		extent.flush();
	}
	

}
