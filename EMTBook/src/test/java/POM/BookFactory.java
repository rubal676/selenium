
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Excel;

public class BookFactory extends Factory
{
	int i=0;

	public BookFactory(WebDriver iDriver) 
	{
		super(iDriver);
	}
	
	
	public void book(Object[][]dp) throws Exception
	{
		
		Thread.sleep(3000);
		Element.getElementProp("FL_DETAILS").click();
		Element.getElementProp("FARE_DETAILS").click();
		Element.getElementProp("TOT_TAX").click();
		Element.getElementProp("BAG_INFO").click();
		Element.getElementProp("CAN_RULES").click();
		//Element.getElementProp("INITIAL_BOOK").click();
		
		Element.getElementProp("INITIAL_BOOK_WITH_MEALS").click();
		
		Element.getElementProp("ADD_INSURANCE").click();
		Element.getElementProp("YES_NO").click();
		Element.getElementProp("EMAIL_GUEST").click();
		Element.getElementProp("EMAIL_GUEST").sendKeys("abc@g.com");
		
		Element.getElementProp("CONT_BOOKING").click();
		
		Thread.sleep(2000);
		
		/*Element.getElementsProp("FIRST_NAME").get(2).click();
		Element.getElementsProp("FIRST_NAME").get(2).sendKeys(firstName);*/
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element.getElementProp("TRA_SCROLL"));
		
		
		
		
		
		for(i=0;i<dp.length;i++)
		{	
			Thread.sleep(2000);
			//ADULT DETAILS
			Element.getElementsProp("FIRST_ADULT").get(i).click();
			Element.getElementsProp("FIRST_ADULT").get(i).sendKeys(dp[i][0].toString());
			
			
			
			Element.getElementsProp("LAST_ADULT").get(i).click();
			Element.getElementsProp("LAST_ADULT").get(i).sendKeys(dp[i][1].toString());
			
			Select adultTitle=new Select(Element.getElementsProp("TITLE_ADULT").get(i));
			adultTitle.selectByVisibleText(dp[i][2].toString());
			
			
			//CHILD DETAILS
			Element.getElementsProp("FIRST_CHILD").get(i).click();
			Element.getElementsProp("FIRST_CHILD").get(i).sendKeys(dp[i][3].toString());
			
			Element.getElementsProp("LAST_CHILD").get(i).click();
			Element.getElementsProp("LAST_CHILD").get(i).sendKeys(dp[i][4].toString());
			
			Select childTitle=new Select(Element.getElementsProp("TITLE_CHILD").get(i));
			childTitle.selectByVisibleText(dp[i][5].toString());
			
			
			//INFANT DETAILS
			Element.getElementsProp("FIRST_INFANT").get(i).click();
			Element.getElementsProp("FIRST_INFANT").get(i).sendKeys(dp[i][6].toString());
			
			Element.getElementsProp("LAST_INFANT").get(i).click();
			Element.getElementsProp("LAST_INFANT").get(i).sendKeys(dp[i][7].toString());
			
			Select infantTitle=new Select(Element.getElementsProp("TITLE_INFANT").get(i));
			infantTitle.selectByVisibleText(dp[i][8].toString());
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element.getElementProp("DOBDAY"));
			
			//if loop makes no changes
			
				Select childDay=new Select(Element.getElementsProp("DOBDAY").get(i));
				childDay.selectByVisibleText(dp[i][9].toString());
				
				Select childMon=new Select(Element.getElementsProp("DOBMON").get(i));
				childMon.selectByVisibleText(dp[i][10].toString());
				
				Select childYear=new Select(Element.getElementsProp("DOBYEAR").get(i));
				childYear.selectByValue("2018");
			
		}
		
		
		
		
		
		Element.getElementProp("MOB_NO").click();
		Element.getElementProp("MOB_NO").sendKeys("8450936011");
		
		Element.getElementProp("GST_BOX").click();
		
	
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Element.getElementProp("ADD_SEAT")));
		
		try {
			Element.getElementProp("PLUS_MEAL").click();
			Element.getElementProp("ADD_BAG").click();
			Element.getElementProp("ADD_SEAT").click();
			Element.getElementProp("SELECT_SEAT").click();
			Element.getElementProp("SEAT_NO").click();
			Element.getElementProp("CONFIRM_SEATS").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
		}
		
		Element.getElementProp("FINAL_BOOK").click();
		
		
		
		
	
	
		
	}

}
