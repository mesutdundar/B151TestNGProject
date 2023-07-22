package techproed.tests.day27_SmokeTest_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C02_BlueRentalExcelTest {
    @Test
    public void test01() {
        //mysmoketestdata excel dosyasindaki 1.satir bilgilerini konsola yazdiralim
        String filePath = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelReader excelReader =new ExcelReader(filePath,sheetName);
        System.out.println("Birinci Email = "+excelReader.getCellData(1, 0));
        System.out.println("Birinci Password = "+excelReader.getCellData(1, 1));
    }
}
