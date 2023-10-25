package tests.day20_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {
//*Cross Broswer'a uygun olarak dizayn edildiden kasit extends TestBaseCross dedik
//* burada olusturulan kucuk driver'i kullanarak butun locate'leri de
// *bu class'in icerisinde yaparak eski usule donup yaptik


    //*Cross Broswer'da kullanicagim driver DriverCross
    //*Cross Broswer testleri POM model ile calismaz
    //*eski usul yapacagiz.

    @Test
    public void amazonTest() {

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedicerik = "Nutella";
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualAramaSonucyazisi = aramaSonucuElementi.getText();
        Assert.assertTrue(actualAramaSonucyazisi.contains(expectedicerik));

    }
    /*
    bizim utilities package'indaki  Driver classimizda
    browser secimimiz configuration.properties'de biz orayi degistiremeyecegimiz icin
    bu Driver classiyla isimizi cozemeyiz. baska bir driver class'ina ihtiyacimiz var.
    o Driver class'i da browser'in ne olacagini configuration.properties'den okumayacak
    bunun yerine xmlFiles'dan gonderilen parametreden olacak

     */
}
