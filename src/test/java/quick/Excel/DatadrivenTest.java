package quick.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DatadrivenTest {


	public ArrayList<String> getdata(String testcaseName) throws IOException {
		
		ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream flis=new FileInputStream("C://Users//Dr Pramod Pandey//Documents//demodata.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(flis);
		
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				//Identify Testcases coumn by scanning the entire 1st row.
				
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=1;
				int column = 1;
				while(ce.hasNext()) {
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						//desired column
						column=k;
					}
					//k++;
				}
				System.out.println(column);
				//System.out.println("Good");
				//once column is identified then scn entire testcase column to identify purchase testcase row
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						
						Iterator<Cell> cv=r.cellIterator();
						
						while(cv.hasNext()) {
							
						Cell c=cv.next();
				
								a.add(c.getStringCellValue());
							
							
						}
					}
				
				}
		
			}
		}
		
		return a;
		
	}
}
