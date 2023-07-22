package techproed.tests.Day26_PagesKullanimi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PageKullanimi  {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
      //  Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
//kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //kullanici=Admin --> .properties dosyasinda
        //kullanicisifre =admin123--> .properties dosyasinda
        /*
        Locateleri olusturdugumuz page class'indaki webelementlere ulasabilmek
        icin asagidaki ornekteki gibi classdaki const.dan obje olusturduk
         */
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.usurname.sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("sifre"));
        ReusableMethods.bekle(3);
        sourcePage.loginButton.click();

//Login Testinin basarili oldugunu test et
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sourcePage.verify.isDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
