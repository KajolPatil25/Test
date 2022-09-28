package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.BrowserAction;

public class UtilityClass extends BrowserAction {
	
		
		
	

		// You can add all one time activites over here and call it according to your need.
	// ============================  Apache Poi  Excel Sheet Utility ==================================================
	
			public static String getStringTestData(int row, int col) throws EncryptedDocumentException, IOException {
				FileInputStream file = new FileInputStream("Resource/MovieName.xlsx");
				String value = WorkbookFactory.create(file).getSheet("movie").getRow(row).getCell(col).getStringCellValue();
				return value;
			}
		
	

}
