package POM;

import org.openqa.selenium.WebDriver;

public class SearchFactory extends Factory
{
	public SearchFactory(WebDriver iDriver) {
		super(iDriver);
	}

	public void search(String data)
	{
		try {
			Thread.sleep(3000);
			System.out.println("In Search");
			Element.getElementProp("S_FROM_OPTION").click();
			Element.getElementProp("S_FROM_OPTION").sendKeys("hello");
			
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}

