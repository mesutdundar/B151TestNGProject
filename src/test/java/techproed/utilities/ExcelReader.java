package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

import java.io.IOException;

public class ExcelReader {
    /*
    Test yaptigimiz sayfadaki datalari .properties ya da excel dosyasindan alabiliriz.
    .properties dosyasindan verileri okuyabilmemiz icin config.reader class'i olusturmustuk, Ayni sekilde excel
    dosyasindaki verileri okuyabilmek icin ExcelReader class'i olusturduk
 */
    Workbook workbook;
    Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //satir ve sutunsayilarini girdigimde , o hucredeki veriyi return eder
    public String getCellData(int row, int column) {
        Cell cell = sheet.getRow(row).getCell(column);
        return cell.toString();
    }
    //Exceldeki satir sayisini return eder
    public int rowCount(){
        return sheet.getLastRowNum();
    }
}
