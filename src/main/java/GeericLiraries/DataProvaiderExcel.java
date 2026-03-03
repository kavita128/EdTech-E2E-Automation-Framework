package GeericLiraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DataProvaiderExcel {

	
	public Object[] [] excelData(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fi1 = new FileInputStream(IPathCostats.DataPrfilePath);
		Workbook wb = WorkbookFactory.create(fi1);
		
		Sheet sh = wb.getSheet(sheetname);
		
		int rowcount = sh.getLastRowNum()+1;
	int cellcount = sh.getRow(0).getLastCellNum();
	Object[] [] oj = new Object[rowcount][cellcount];
		for(int i=0; i<rowcount;i++)//row
		{
			for(int j=0;j<cellcount;j++)//cell
			{
			oj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
}
		}
		return oj;
		
	}
}



