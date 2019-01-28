package utils;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testexecution.Base;

public class LoadProperty extends Base
{
	Properties prop=null;
	
	public LoadProperty(String Location)
	{
		prop=new Properties();
		try 
		{
			prop.load(new FileInputStream(Location));
		} 
		catch (Exception e) 
		{
			System.out.println("Error with Property file");			

		} 
	}

	public LoadProperty(String Location,WebDriver driver)
	{	
		this(Location);
		this.driver=driver;
	}

	public   String getProp(String Key)
	{
		return prop.getProperty(Key);
	}

	public   WebElement getElementProp(String Key)
	{
		WebElement Element=null;
		String LocatorType=prop.getProperty(Key).split(":")[1];
		String LocatorValue=prop.getProperty(Key).split(":")[0];


		if(LocatorType.equalsIgnoreCase("id"))
		{
			Element=driver.findElement(By.id(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("name"))
		{
			Element=driver.findElement(By.name(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("css"))
		{
			Element=driver.findElement(By.cssSelector(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("linktext"))
		{
			Element=driver.findElement(By.linkText(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			Element=driver.findElement(By.xpath(LocatorValue));
		}
		else 
			System.out.println("invalid locator");


		return Element;

	}

	public   List<WebElement> getElementsProp(String Key)
	{
		List<WebElement> Element=null;
		String LocatorType=prop.getProperty(Key).split(":")[1];
		String LocatorValue=prop.getProperty(Key).split(":")[0];


		if(LocatorType.equalsIgnoreCase("id"))
		{
			Element=driver.findElements(By.id(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("name"))
		{
			Element=driver.findElements(By.name(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("css"))
		{
			Element=driver.findElements(By.cssSelector(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("linktext"))
		{
			Element=driver.findElements(By.linkText(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			Element=driver.findElements(By.xpath(LocatorValue));
		}
		else 
			System.out.println("invalid locator");

		return Element;	
	}
}

