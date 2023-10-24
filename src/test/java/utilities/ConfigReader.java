package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   // ConfigReader'in amaci
   // configuration.properties'le benim test class'larimin arasina araci yapmak

    //ozetle bu classla ilgili ne is yaparsaniz yapin once static blok calisacagi icin
    //16.satirdaki properties objesi'ne gidip configuration.properties dosyasini
    //okuyacak ve properties objesine yukleyecek (bu ilk is)

    static Properties properties; // static olarak properties objesi olusturmusuz.

    static { // static blok her seyden once calisir

        String dosyaYolu= "src/configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(dosyaYolu); //dosya yolunu okuyacak
            properties= new Properties();
            properties.load(fis); //properties objesine yukleyecek


        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");

        }

    }
    //try-catch yapmasinin nedeni de cunku  FileInputStream olusturursan ya bulamazsam der.
    // bizde onu rahatlamak icin diyoruz ki bulamazsan Exception firlat
    // bi de bu aciklamayi yazdir.nasil olsa bulacak


    public static String getProperty(String key){

        return properties.getProperty(key); // key=amazonUrl buraya gelecek

    }

    /*
    39.satir ve 43.satir arasi
    key olarak amazonUrl diyecegiz getProperty methodunu kullanarak daha sonra
    key=amazonUrl 41.satira gelecek
    properties objesi de amazonUrl'in property'sini getirecek

    properties objesine yuklenmis olan key value ikililerinden istedigimiz key'e ait
    value'yu bize döndürecek.
     */


}