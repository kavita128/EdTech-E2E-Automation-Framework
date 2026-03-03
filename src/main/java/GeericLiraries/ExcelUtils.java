package GeericLiraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
/**
 * ReadDataFromExcel
 * @param sheetname
 * @param rowno
 * @param cellno
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
	FileInputStream fi = new FileInputStream(IPathCostats.excelPath);
	 Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetname);
	 String value = sh.getRow(rowno).getCell(cellno).getStringCellValue();
	 	 return value;
}
	/**
	 * ReadMultipleDataFromExcel
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
	{
	FileInputStream fi = new FileInputStream(IPathCostats.excelPath);
	 Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetname);
	 int lastRow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		
		ArrayList<String>list = new ArrayList<>();
		for(int i=0; i<lastRow;i++)//row
		{
			for(int j=0;j<lastcell;j++)//cell
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
			
		}
		return list;
	}
	/**
	 * getRowCount
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount (String sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream(IPathCostats.excelPath);
	 Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetname);
	int rowCount = sh.getLastRowNum();
	return rowCount;
}

	/**
	 * getCellCount
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount (String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathCostats.excelPath);
		 Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(sheetname);
		int celCount = sh.getRow(0).getLastCellNum();
		return celCount;
		
	}
	
	/** 
	 * writeDataIntoExcel
	 * @param sheetname
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetname, Date value) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathCostats.excelPath);
		 Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(sheetname);
		 Row row = sh.getRow(0);
		 Cell cel = row.createCell(0);
		 cel.setCellType(CellType.STRING);
		 cel.setCellValue(value);
		 
		 FileOutputStream fos = new FileOutputStream(IPathCostats.excelPath);
		 wb.write(fos);
		 wb.close();
		 
		 
	}
}









