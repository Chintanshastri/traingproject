package util;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utildatafile {
static XSSFWorkbook woorkbook;
static XSSFSheet sheet;

//constructor
public Utildatafile(String excelPath, String sheetName) {
	
	try {
		woorkbook = new XSSFWorkbook(
				excelPath);
		// HSSFWorkbook woorkbook = new HSSFWorkbook(); for old file
		sheet = woorkbook.getSheet(sheetName);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}

	public static void main(String[] args) {
		//getRowCount();
		//getCellDataString(0, 0);
		//getCellDataNumber(1, 1);
	}

	public static int getRowCount() {
		int rowCount=0;
		try {
			 
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("no of row : " + rowCount);

		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getcolCount() {
		int colCount=0;
		try {
			 
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("no of col : " + colCount);

		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}

	public static String getCellDataString(int rowNum , int colNum) {
		String cellData=null;
		try {
			/* woorkbook = new XSSFWorkbook(
					"C:\\Users\\user4\\eclipse-workspace\\Trainginproject\\excel\\loginfile.xlsx");

			sheet = woorkbook.getSheet("login");
			*/
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	/*public static void getCellDataNumber(int rowNum , int colNum) {

		try {
			 woorkbook = new XSSFWorkbook(
					"C:\\Users\\user4\\eclipse-workspace\\Trainginproject\\excel\\loginfile.xlsx");

			sheet = woorkbook.getSheet("login");
			
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.print(cellData);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print(e.getCause());
			e.printStackTrace();
		}
	}*/
}
