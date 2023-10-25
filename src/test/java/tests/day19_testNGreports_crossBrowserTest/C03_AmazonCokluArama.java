package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_AmazonCokluArama {

    @Test
    public void amazonTopluArama(){

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // verilen listedeki her bir urun icin arama yaptirin
        // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

        String[] aranacakUrunler = {"Nutella","Java","Armut","elma","Erik","Malatya"};
        AmazonPage amazonPage = new AmazonPage();
        String aramaSonucu;
        String[] aramaSonucKelimeleri;
        String aramasonucSayisiStr;
        int aramaSonucSayisiInt;

        for (int i = 0; i < aranacakUrunler.length ; i++) {

            amazonPage.aramaKutusu.clear(); //*NutellaJava olmasin diye temizliyoruz
            amazonPage.aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);

            aramaSonucu = amazonPage.sonucYaziElementi.getText();
            aramaSonucKelimeleri = aramaSonucu.split(" ");

            if (aramaSonucKelimeleri[2].equals("over")){ //*2.index'deki "over"sa
                aramasonucSayisiStr = aramaSonucKelimeleri[3];//*3.index'i alayim
            }else{
                aramasonucSayisiStr = aramaSonucKelimeleri[2];//*degilse 2.index'i alayim
            }

            aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D","");
            aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr);
            //*artik Integar'a cevirebilirim

            Assert.assertTrue(aramaSonucSayisiInt>100);
        }


    }
}
