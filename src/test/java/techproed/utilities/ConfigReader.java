package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
.properties uzantılı dosyaya erişebilmemiz için Properties class'ından obje oluşturmamız gerekir.
bu oluşturduğumuz obje ile akışa aldığımız dosya yolunu load(fis) methodu ile properties dosyasındaki
key değerini return edebiliriz
 */
   static Properties properties ;
   static {
       try {
           FileInputStream fis = new FileInputStream( "configuration.properties");
           properties = new Properties();
           properties.load(fis);//--> fis'in okudugu bilgileri properties'e yukler
            fis.close();//close the file
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }
    public static String getProperty (String Key){
       String value= properties.getProperty(Key);//-->getProperty(Key) methodu properties dosyasindaki key'in degerini verir
        return value;
    }
}
