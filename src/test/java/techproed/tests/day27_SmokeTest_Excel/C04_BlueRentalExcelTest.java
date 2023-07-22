package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

import java.security.Key;

public class C04_BlueRentalExcelTest {
    @Test
    public void test01() {
        //Excel dosyamızdaki tüm email ve password'ler ile
//BlueRentalCar sayfasına gidip login olalım
        String filePath = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelReader excelReader =new ExcelReader(filePath,sheetName);
        //sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //bir loop olusturup excel dosyasindaki tum veriler ile login olalim
        BlueRentalPage rentalPage = new BlueRentalPage();

        for (int i = 1; i <=excelReader.rowCount() ; i++) {//reaader.rowcount satir sayisini veren methot, excel readerda var
            String email=excelReader.getCellData(i,0);
            String password = excelReader.getCellData(i,1);
            System.out.println(email +" || "+ password );
            rentalPage.login.click();
            ReusableMethods.bekle(2);
            rentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            Actions actions = new Actions(Driver.getDriver());
            actions.click(rentalPage.profilNameDdm).perform();
            ReusableMethods.bekle(3);
            Assert.assertTrue(rentalPage.profilButtonVerify.isDisplayed());
            rentalPage.logOut.click();
            rentalPage.logOutOKButton.click();
        }
        //sayfayi kapat
        Driver.closeDriver();

    }
}
