package POM;

import org.openqa.selenium.WebDriver;

public class LoginFactory extends Factory
{
	public LoginFactory(WebDriver iDriver)
	{
		super(iDriver);
	}
	
	public void Login(String username,String Password)
	{
		
		
		Element.getElementProp("E_LOGIN").click();
		
		Element.getElementProp("E_EM").sendKeys(username);
		Element.getElementProp("E_PWD").sendKeys(Password);
		Element.getElementProp("E_LG").click();
	}
}


