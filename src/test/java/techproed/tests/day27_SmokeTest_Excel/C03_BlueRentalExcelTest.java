package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

import javax.swing.*;

public class C03_BlueRentalExcelTest {
    @Test
    public void test01() {
        ExcelReader reader = new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email=reader.getCellData(1,0);
        String password =reader.getCellData(1,1);

        //bluerantalcar sayfasina gidelim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

//my    smoketestdata excel dosyasindan bir kullanici ile login olalim
        blueRentalPage.login.click();
        ReusableMethods.bekle(2);
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
//login oldugumuzu dogrulayalim
        Assert.assertTrue(blueRentalPage.loginVerify.isDisplayed());
        ReusableMethods.bekle(2);
//sayfayi kapatalim
        Driver.closeDriver();
    }
}
