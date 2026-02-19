package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {
	
	public static String getExcelData(String sheetName, int row, int cell) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\EclipsePractice\\Parameterization.xlsx");
		
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}

}
