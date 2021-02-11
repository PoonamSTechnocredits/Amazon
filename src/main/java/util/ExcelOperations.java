package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static String[][] readExcelData(String filePath, String sheetName) throws IOException {

		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);
		Workbook wb;
		if (filePath.contains(".xlsx"))
			wb = new XSSFWorkbook(input);
		else
			wb = new HSSFWorkbook(input);
		Sheet sheet = wb.getSheet(sheetName);

		int totalRows = sheet.getLastRowNum() + 1;
		int totalCol = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[totalRows][totalCol];

		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalCol; j++) {
				if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				} else if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
					data[i][j] = sheet.getRow(i).getCell(j).getNumericCellValue() + "";
				}
			}
		}
		return data;
	}

}
