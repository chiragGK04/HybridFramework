package com.genericlib.demoblaze;

import java.io.File;
import java.io.IOException;


import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class Eventlist implements ITestListener
{
	

	public void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)Baseclass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("test-output/Screenshots/"+System.currentTimeMillis()+".png");
		String path = dst.getAbsolutePath();
		try {
			FileHandler.copy(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Baseclass.test.fail("test case fails"+result.getThrowable().toString(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}
	
	

}
