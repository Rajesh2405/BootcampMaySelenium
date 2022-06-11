package week3;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class HashmapExcelRead {
	
	@DataProvider(name="dp")
	private Object[][] getData(Method m) throws IOException {
		String Sheetname = m.getName();
		System.out.println(Sheetname);
		FileInputStream fis = new FileInputStream("./Data/SampleData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet xsheet = wb.getSheet(Sheetname);
		
		int lastRow = xsheet.getLastRowNum();
		int lastCell = xsheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][1];
		
		for (int i = 0; i < lastRow; i++) {
			
		HashMap<Object, Object> datamap = new HashMap<Object, Object>();
		
		for (int j = 0; j < lastCell; j++) {
			
			datamap.put(xsheet.getRow(0).getCell(j).toString(), xsheet.getRow(i+1).getCell(j).toString());
		}
		obj[i][0]= datamap;
		
	}
		return obj;

}
}
