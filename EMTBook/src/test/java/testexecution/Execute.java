package testexecution;

import org.testng.annotations.Test;

import POM.BookFactory;
import POM.BookMultiFactory;
import POM.BookRoundFactory;
import POM.BookSinglePassenger;
import POM.SearchFactory;
import POM.TravellersFactory;
import utils.Excel;
import org.testng.annotations.DataProvider;


public class Execute extends Base
{	
	
	//ONE WAY WORKING
  /*@Test(priority=1,dataProvider="BookData")
  public void bookTest(String firstName, String lastName) throws Exception
  {
	  System.out.println("book one way test");
	  BookFactory bf= new BookFactory(driver);
	 														
	  bf.book(Excel.MyDataProvider("Sheet1",12));  
  }*/
  
 /* @DataProvider
 	public Object[][] BookData() throws Exception
 	{
 		Object data[][]=Excel.MyDataProvider("Sheet1", 2);
 		return data;
 	}*/
   
  
  
  //ROUND TRIP WORKING USING BookData()
/*  @Test(priority=1,dataProvider="BookData")
  public void bookRoundTest(String firstName, String lastName) throws Exception
  {
	  System.out.println("book round test");
	  BookRoundFactory bf=new BookRoundFactory(driver);
	 
	  bf.bookRound(Excel.MyDataProvider("Sheet1",12));
  
  }*/
	
	//MULTI CITY WORKING USING BookData()
	/*@Test(priority=1,dataProvider="BookData")
	  public void bookMultiTest(String firstName, String lastName) throws Exception
	  {
		  System.out.println("book multi test");
		  BookMultiFactory bf=new BookMultiFactory(driver);
		 
		  bf.bookMulti(Excel.MyDataProvider("Sheet1",12));
	  
	  }*/
	
	
	//BOOK SINGLE PASSENGER
	@Test(dataProvider="SingleData")
	  public void bookSinglePassenger(String EmailID,String FNAME,String LNAME,String Title, String MNumber) throws Exception
	  {
		  System.out.println("book single passenger test");
		  BookSinglePassenger bf=new BookSinglePassenger(driver);
		 
		  bf.bookSingle( EmailID, FNAME, LNAME, Title, MNumber);
	  
	  }
	
	@DataProvider
 	public Object[][] SingleData() throws Exception
 	{
 		Object data[][]=Excel.MyDataProvider("Sheet2", 5);
 		return data;
 	}
  

}
