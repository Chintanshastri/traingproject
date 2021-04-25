package util;

public class Utilcalling {
public static void main(String[] args) {
	Utildatafile excel = new Utildatafile("C:\\Users\\user4\\eclipse-workspace\\Trainginproject\\excel\\loginfile.xlsx" , "login");
	excel.getRowCount();
	excel.getcolCount();
	excel.getCellDataString(0,0);
	//excel.getCellDataNumber(1,1);
	
}
}
