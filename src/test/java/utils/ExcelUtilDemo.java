package utils;

import java.io.IOException;

public class ExcelUtilDemo {
    public static void main(String[] args) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/data.xlsx","Sheet1");
        excelUtils.getRowCount();
        excelUtils.getCellData(1,0);
        excelUtils.closeExcel();
    }
}
