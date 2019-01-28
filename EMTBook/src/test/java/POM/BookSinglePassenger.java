package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testexecution.Base;
import utils.Util;

public class BookSinglePassenger extends Factory 
{
	By invalidMail= By.id("divErrorEmail");
	By invalidMobile = By.id("divErrorTraveller");
	public BookSinglePassenger(WebDriver iDriver) 
	{
		super(iDriver);
	}
	
	public void bookSingle(String EmailID,String FNAME,String LNAME,String Title, String MNumber) throws Exception
	{
		Element.getElementProp("BOOK_WITH_MEALS").click();
		
		Element.getElementProp("ADD_INSURANCE").click();
		Element.getElementProp("YES_NO").click();
		Element.getElementProp("EMAIL_GUEST").click();
		Element.getElementProp("EMAIL_GUEST").sendKeys(EmailID);
		
		
		
		Element.getElementProp("CONT_BOOKING").click();
		Util.verifyOnInvisibilty(2, invalidMail, "Review Page", "Invalid Email ID");
		//Util.verifyOnVisibilty(10, invalidMail, "Review Page", "Invalid Email ID");
		

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element.getElementProp("TRA_SCROLL"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(Element.getElementsProp("FIRST_ADULT").get(0)));
		
		Thread.sleep(2000);
		
			Element.getElementsProp("FIRST_ADULT").get(0).click();
			Element.getElementsProp("FIRST_ADULT").get(0).sendKeys(FNAME);
			
			Util.verifyOnEnability("FirstName", "Error on FirstName");
			
			
			
			
			Element.getElementsProp("LAST_ADULT").get(0).click();
			Element.getElementsProp("LAST_ADULT").get(0).sendKeys(LNAME);
			
			

			
			Select adultTitle=new Select(Element.getElementsProp("TITLE_ADULT").get(0));
			adultTitle.selectByVisibleText(Title);
			
		
		
		
		Element.getElementProp("MOB_NO").click();
		Element.getElementProp("MOB_NO").sendKeys(MNumber);
		
		
		
		Element.getElementProp("GST_BOX").click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Element.getElementProp("ADD_SEAT")));
		
		
	
		
		try 
		{
			Element.getElementProp("PLUS_MEAL").click();
			Element.getElementProp("ADD_BAG").click();
			Element.getElementProp("ADD_SEAT").click();
			Element.getElementProp("SELECT_SEAT").click();
			Element.getElementProp("SEAT_NO").click();
			Element.getElementProp("CONFIRM_SEATS").click();
		} 
		catch (Exception e) 
		{
			
			System.out.println("ADD ONS UNAVAILABLE");
		}
		
		Element.getElementProp("FINAL_BOOK").click();
		Util.verifyOnInvisibilty(2, invalidMobile, "Review Page", "Invalid Mobile Number");
		
	}
}
