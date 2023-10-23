package tests.day16_testNG_framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void nutellaTesti(){

        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapalim
        AmazonPage amazonPage = new AmazonPage(); // locate AmazonPage sayfasinda
        // pages sayfasina ulasabilmek icinde TestNG obje olusturmami uygun gormus

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        // arama sonuclarinin Nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        //driver classindanki closeDriver()'i kullanarak driver'i kapatalim
        Driver.closeDriver();
    }

   // ***TestNG pages Object modelindeki amacimiz bir testin icinde
   // ***hicbir locate hicbir test datasi olmamasi

}
