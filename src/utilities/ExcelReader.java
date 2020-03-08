package utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
	private List<String[]> arrayExcelData = new ArrayList<String[]>();

	//this method will read and return from an xlsx file
	public void run(String filename) throws IOException,InvalidFormatException {
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
		
		Workbook workbook = WorkbookFactory.create(inputStream);

		Sheet sheet = workbook.getSheetAt(0);

		int rownum = sheet.getLastRowNum();
		int colnum = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rownum; i++) {
			String[] testRow= new String[colnum];
			for (int j = 0; j < colnum; j++) {
				Cell cell;
				cell = sheet.getRow(i).getCell(j);
				testRow[j] = cell.toString();
			}
			arrayExcelData.add(testRow);
		}
		workbook.close();
	}
	public List<String[]> getArrayExcelData() {
		return arrayExcelData;
	}
	

}