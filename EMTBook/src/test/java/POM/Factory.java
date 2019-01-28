package POM;

import org.openqa.selenium.WebDriver;

import utils.LoadProperty;

public class Factory 
{
	WebDriver driver;
	LoadProperty Element;
	public Factory(WebDriver iDriver)
	{
		this.driver=iDriver;
		Element=new LoadProperty(".\\constants.property",driver);
	}
}
