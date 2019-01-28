package utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Util 
{
	static WebDriver w;
	public static WebDriverWait wait;    
	public static WebDriver startBrowser(String Location)
	{
		if (Location.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", Location);
			w = new ChromeDriver();
			
		} 
		else if (Location.contains("gecko")) {
			System.setProperty("webdriver.gecko.driver", Location);
			w = new FirefoxDriver();
		}
		w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return w;

	}

	public static void captureScreenshot(String name) throws Exception 
	{
		TakesScreenshot screen = (TakesScreenshot) w;
		File src = screen.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String screenshotName = name + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println(screenshotName);

		FileUtils.copyFile(src, new File(".\\drivers\\" + screenshotName));

	}

	public static void captureScreenshot2(String name) 
	{
		try 
		{

			// Creating Robot class object
			Robot robotClassObject = new Robot();

			// Get screen size
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

			// Capturing screenshot by providing size
			BufferedImage tmp = robotClassObject.createScreenCapture(screenSize);

			Date d = new Date();
			String screenshotName = name + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			// To copy temp image in to permanent file
			ImageIO.write(tmp, "png", new File(".\\drivers\\", screenshotName));

		} 
		catch (Exception e) 
		{
			System.out.println("Some exception occured." + e.getMessage());

		}

	}

	public static void verifyOnEnability(String ScreenName,String Message) throws Exception
	{
		try
		{
			new Actions(w).sendKeys(Keys.TAB).perform();
			new Actions(w).sendKeys(Keys.TAB).perform();

		}
		catch(UnhandledAlertException U)
		{
			Thread.sleep(2000);
			Util.captureScreenshot2(ScreenName);
			w.switchTo().alert().accept();
			w.navigate().back();
			Assert.fail(Message);
		}
	}


	public static void verifyOnVisibilty(int time, By ByLocator,String ScreenName,String Message) throws Exception
	{
	try
	{
		new WebDriverWait(w, time).until(ExpectedConditions.visibilityOf(w.findElement(ByLocator)));
	}
	catch(Exception e)
	{
		captureScreenshot2(ScreenName);
		Assert.fail(Message);
	}
	}
	
	
	public static void verifyOnInvisibilty(int time, By ByLocator,String ScreenName,String Message) throws Exception
	{
	try
	{
		new WebDriverWait(w, time).until(ExpectedConditions.invisibilityOf(w.findElement(ByLocator)));
	}
	catch(Exception e)
	{
		captureScreenshot2(ScreenName);
		w.navigate().back();
		Assert.fail(Message);
	}
	}


}




