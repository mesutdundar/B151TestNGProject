package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    /*
    Birden fazla test methodu çalıştırmak istediğimizde o anlık gereksiz gördügümüz test methodunu
    atlamak (ignore) isteyebiliriz. Bunun için @Test notasyonu üstüne yada yanına @Ignore notasyonu
    eklememiz yeterlidir.@Ignore notasyonu ile atladığımız method konsolda gözükmez raporlamalarda gözükür
     */
    @Ignore
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");//-->ikinci olarak amazon çalışsın
    }
    @Test(enabled = false) /** bu methodu tamamen iptal etti . Raporlamada da gozukmez!!!!zaten calistir butonu da kayboldu */
    public void youtubeTest() {
        driver.get("https://youtube.com");//-->youtube önce çalışsın--> Default 0 olduğu için önce bu method çalışır
    }
    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");//-->Son olarak facebook çalışsın
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
