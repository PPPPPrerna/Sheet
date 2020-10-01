package quick.Excel;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class SampleTest {

	@Test
	public void  samp() throws IOException {
	
		Cool d = new Cool();
	
	ArrayList<String> data=d.show("Add Profile");
	ArrayList<String> data1=d.show("Purchase");
	System.out.println(data);
	System.out.println(data1);
	
	
	
	}
}
