package quick.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Cool {

	public ArrayList<String> show(String testcasename) throws IOException {
	FileInputStream fl = new FileInputStream("C://Users//Dr Pramod Pandey//Documents//demodata.xlsx");
	ArrayList<String> al=new ArrayList<String>();
	
	XSSFWorkbook word = new XSSFWorkbook(fl);
	//ArrayList<String> al=new ArrayList<String>();

	
	XSSFSheet sheet = word.getSheet("testdata");
	int a=word.getNumberOfSheets();
	
	System.out.println("New values");
	System.out.println("New values");
	
	
		
		Iterator<Row> row=sheet.iterator();
		int k=0;
		int column=0;
		
		while(row.hasNext()) {
			
			if(row.next().getCell(column).getStringCellValue().equalsIgnoreCase("Testcases")) {
				//column=k;
			
			//k++;
				System.out.println("aa");
			}
		
				
				while(row.hasNext()) {
					
					Row r1=row.next();
					if(r1.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						
						Iterator<Cell> cell =r1.cellIterator();
						
						while(cell.hasNext()) {
							
							//Cell c=cell.next();
				
							al.add(cell.next().getStringCellValue());
						
						
					}
					}
				}
				
			}
		
			//k++;
		

		
		
	
	
	
	
	
	
	
	
		return al;
}
	}