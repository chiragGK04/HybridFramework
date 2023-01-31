package com.testscripts.demoblaze;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Baseclass;
import com.genericlib.demoblaze.Eventlist;

@Listeners(Eventlist.class)
public class ContactDemoBlaze extends Baseclass
{
	@Test
	public void contactdemoTest() throws IOException
	{
		test=extent.createTest("contact report");
		
		test.pass("logged in");
		
		hp.getContact().click();
		test.pass("navigated to contact page");
		cu.waitforSendmsgClickable(driver, hp.getSendmsg());
		hp.getEmailid().sendKeys(fl.getdatafromproperties(propath1, "emailid"));
		hp.getContactname().sendKeys(fl.getdatafromproperties(propath1, "contactname"));
		hp.getMessage().sendKeys(fl.getdatafromproperties(propath1, "message"));
		test.pass("entered contact details");
		hp.getSendmsg().click();
		test.pass("message sent successfully");
		cu.accepAlert(driver);
		test.pass("allert has been handled");
	}

}
