package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage 
{
	@FindBy(id="login2")
	private WebElement login;
	
	@FindBy(id="loginusername")
	private WebElement username;
	
	@FindBy(id="loginpassword")
	private WebElement password;
	
	@FindBy(xpath="//button[.='Log in']")
	private WebElement loginbutton;
	
	@FindBy(id="nameofuser")
	private WebElement verifylogin;
	
	@FindBy(xpath="//a[.='Samsung galaxy s6']")
	private WebElement SamsungGalaxyS6;
	
	@FindBy(xpath="//a[.='Add to cart']")
	private WebElement addtocart;
	
	@FindBy(id="cartur")
	private WebElement cart;
	
	@FindBy(id="logout2")
	private WebElement logout;
	
	@FindBy(xpath="//a[.='Delete']")
	private WebElement cartdeleteproduct;
	
	//contact
	
	@FindBy(xpath="//a[.='Contact']")
	private WebElement contact;
	
	@FindBy(id="recipient-email")
	private WebElement emailid;
	
	@FindBy(id="recipient-name")
	private WebElement contactname;
	
	@FindBy(id="message-text")
	private WebElement message;
	
	@FindBy(xpath="//button[.='Send message']")
	private WebElement sendmsg;
	
	
	//getters

	public WebElement getContact() {
		return contact;
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getContactname() {
		return contactname;
	}

	public WebElement getMessage() {
		return message;
	}

	public WebElement getSendmsg() {
		return sendmsg;
	}

	public WebElement getCartdeleteproduct() {
		return cartdeleteproduct;
	}

	public void setCartdeleteproduct(WebElement cartdeleteproduct) {
		this.cartdeleteproduct = cartdeleteproduct;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getVerifylogin() {
		return verifylogin;
	}

	public WebElement getSamsungGalaxyS6() {
		return SamsungGalaxyS6;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

	public WebElement getCart() {
		return cart;
	}

}
