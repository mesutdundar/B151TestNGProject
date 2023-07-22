package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/*
POM(Page Object Model)
    Test senaryolarinin daha az kod ile yazilmasina ve bakiminin daha kolay yapilmasina
olanak saglayan yazilim test yontemidir. TestNG de ve CUCUMBER da POM kalibini kullaniriz
 */
public class Driver {
    private Driver(){
        /*
Driver class'ından obje oluşturmanın önüne geçmek için
default constructor'ı private yaparak bunun önüne geçebiliriz
Bu uygulamaya singleton pattern denir
 */
    }
    static WebDriver driver;

    public static WebDriver getDriver(){
           /*
            Driver 'i her cagirdigimizda yeni bir pencere acilmasinin onune gecmek icin
         if blogu icinde Eger driver'a degere atanmamissa deger ata, eger deger atanmissa
         Driver'i ayni sayfada return et
           */
        /*
        Properties dosyasinda key olarak belirttigimiz browser'a asagidaki gibi hangi degeri
        belirtirsek testlerimi o browser ile calisir
         */
        if (driver==null){
          switch (ConfigReader.getProperty("browser")){
              case "chrome":
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
                  break;
              case "edge":
                  WebDriverManager.edgedriver().setup();
                  driver= new EdgeDriver();
                  break;
              case "safari":
                  WebDriverManager.safaridriver().setup();
                  driver = new SafariDriver();
                  break;
              default:
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
          }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver !=null){//-->driver'a deger atanmissa
            driver.close();
            driver=null;// --> driver'i kapattiktan sonra bosalt
        }

    }
    public static void quitDriver(){
        if (driver !=null){//-->driver'a deger atanmissa
            driver.quit();
            driver=null;// --> driver'i kapattiktan sonra bosalt
        }
    }
}
