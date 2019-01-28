package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TravellersFactory extends Factory
{
	int i=0;
	public TravellersFactory(WebDriver iDriver) 
	{
		super(iDriver);
	}
	
	public void traveller(String firstName, String lastName)
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element.getElementsProp("FIRST_NAME").get(0));
		
		System.out.println(Element.getElementsProp("FIRST_NAME").get(0).getText());
		
		Element.getElementsProp("FIRST_NAME").get(0).click();
		Element.getElementsProp("FIRST_NAME").get(0).sendKeys(firstName);
		
		Element.getElementsProp("LAST_NAME").get(0).click();
		Element.getElementsProp("LAST_NAME").get(0).sendKeys(lastName);
		i++;
	}

}
