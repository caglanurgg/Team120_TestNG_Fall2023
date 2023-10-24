package tests.day17_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_configurationPropertiesKullanimi {

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // parantezin icin configuration.properties dosyasindan amazonUrl'i
        // bana getirecek bir seyler yazmam lazim
        // artik buraya https://www.amazon.com degil
        // git configuration.properties'dan amazonUrl'i getir diyecegiz.
        //configuration.properties java alaninin  disina src'nin altina koyduk

        // arama kutusuna aranacak kelimeyi yazdirin ve aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime") + Keys.ENTER);

        //ConfigReader.getProperty= meydanci'ya diyorum ki
        // bana utilities package'indaki ConfigReader class'inda bulunan
        // "amazonAranacakKelime" yi getir.
        // meydanci da ilk once configuration.properties'e gidiyor amazonAranacakKelime olan
        // Nutella'yla donuyor. Nutella'yi da bana getiriyor.


        // arama sonuclarinin aranan kelimeyi icerdigini test edin
        String expectedIcerik = ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucu = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));

        // sayfayi kapatin
        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
}
