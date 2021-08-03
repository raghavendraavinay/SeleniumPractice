package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        xssfWorkbook = new XSSFWorkbook(excelPath);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
    }

    public void closeExcel() throws IOException {
        this.xssfWorkbook.close();
    }

    public int getRowCount() throws IOException {
        System.out.println("Total Rows: "+this.xssfSheet.getPhysicalNumberOfRows());
        return this.xssfSheet.getPhysicalNumberOfRows();
    }

    public String getCellData(int rowNum, int colNum) throws IOException {

        String data = this.xssfSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//        System.out.println("Get Cell data: "+data);
        return data;
    }

    public int getColumnCount(){
        System.out.println("Column Count: "+this.xssfSheet.getRow(0).getPhysicalNumberOfCells());
        return this.xssfSheet.getRow(0).getPhysicalNumberOfCells();
    }
}
