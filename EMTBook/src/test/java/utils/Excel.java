package utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	static Sheet s;
	static Workbook wb;
	public static void ExcelConfig(String Location ,String SheetName)
	{
		try
		{
			FileInputStream I=new FileInputStream(Location);
			if(Location.endsWith("xls")==true)
			{
				wb=new HSSFWorkbook(I);

				s=wb.getSheet(SheetName);
			}

			else if(Location.endsWith("xlsx")==true)
			{
				wb=new XSSFWorkbook(I);

				s=wb.getSheet(SheetName);
			}
			else
			{
				System.out.println("Invalid Format");
			}
		}
		catch(Exception E)
		{
			System.out.println("Error while Reading File");
		}
	}

	public static String  Read(int R,int C)
	{
		return s.getRow(R).getCell(C).getStringCellValue();
	}

	public static int ROWNUM()
	{
		return s.getLastRowNum();
	}

	public static Object[][] MyDataProvider(String sheet,int column) throws Exception
	{

		Sheet customSheet =wb.getSheet(sheet);
		Object[][] data = new Object[customSheet.getLastRowNum()][column];
		for(int r=1;r<=customSheet.getLastRowNum();r++)
		{

			for(int c=0;c<column;c++)
			{
				String cellData=null;
				try
				{
					cellData=customSheet.getRow(r).getCell(c).toString();
					if(cellData.endsWith(".0"))
						cellData=cellData.split("\\.")[0];

				}
				catch(NullPointerException N)
				{
					cellData=null;
				}
				System.out.println(cellData);
				data[r-1][c]= cellData;
			}
		}

		return data;
	}
	
	public static Object[][] MyDataProvider1(String sheet,int column) throws Exception
	{

		Sheet customSheet =wb.getSheet(sheet);
		Object[][] data = new Object[customSheet.getLastRowNum()][column];
		for(int r=1;r<=customSheet.getLastRowNum()-1;r++)
		{

			for(int c=0;c<column;c++)
			{
				String cellData=null;
				try
				{
					cellData=customSheet.getRow(r).getCell(c).toString();
					if(cellData.endsWith(".0"))
						cellData=cellData.split("\\.")[0];

				}
				catch(NullPointerException N)
				{
					cellData=null;
				}
				System.out.println(cellData);
				data[r-1][c]= cellData;
			}
		}

		return data;
	}
}
