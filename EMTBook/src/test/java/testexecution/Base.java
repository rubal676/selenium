package testexecution;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import POM.LoginFactory;
import utils.Excel;
import utils.Util;

public class Base 
{
	protected static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest Test;
	LoginFactory LF;
	
  @BeforeTest
  public void beforeTest() 
  {
	  driver=Util.startBrowser(".\\drivers\\chromedriver.exe");
	  driver.manage().window().maximize();
	  
	  // For Book One Way
	  //driver.get("https://flight.easemytrip.com/FlightList/Index?org=DEL-Delhi,%20India&dept=BOM-Mumbai,%20India&adt=1&chd=1&inf=1&cabin=4&airline=undefined&deptDT=19/06/2019&arrDT=undefined&isOneway=true&isDomestic=false&");
	  
	  //For Book Round Trip
	  //driver.get("https://flight.easemytrip.com/FlightListRT/Index?org=DEL-Delhi,%20India&dept=BOM-Mumbai,%20India&adt=1&chd=1&inf=1&cabin=4&airline=Any&deptDT=14/10/2019&arrDT=12/11/2019&isOneway=false&isDomestic=true&CouponCode=");
	  
	 //For Book Multi City
	 //driver.get("https://flight.easemytrip.com/multicity/Index?SrchID=BOM-Mumbai,%20India|DEL-Delhi,%20India|23/07/2019^DEL-Delhi,%20India|MAA-Chennai,%20India|23/07/2019&adt=1&chd=1&inf=1&cabin=4&airline=Any&isOneway=true&isDomestic=false&ompAff=easemytrip&lead=12");
	  
	  //FOR BOOK SINGLE
	  driver.get("https://flight.easemytrip.com/FlightList/Index?org=DEL-Delhi,%20India&dept=BLR-Bangalore,%20India&adt=1&chd=0&inf=0&cabin=0&airline=Any&deptDT=23/07/2019&arrDT=&isOneway=true&isDomestic=true&CouponCode=");
	  
	  
	  
      //Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\BENASH\\BookDetails.xlsx", "Sheet1");
	  
	  //For Invalid
      Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\BENASH\\InvalidBook.xlsx", "Sheet1"); 
  }
  
  
  

  /*@AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }*/

}
