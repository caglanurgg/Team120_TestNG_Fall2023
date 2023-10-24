package tests.day18_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_SoftAssertion {

    @Test
    public void zeroAppTesti(){
        //. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroAppUrl"));
        //ConfigReader.getProperty= meydanci'ya diyorum ki
        // bana utilities package'indaki ConfigReader class'inda bulunan
        // "zeroAppUrl" yi getir.

        // 2. Sign in butonuna basin
        ZeroAppPage zeroAppPage = new ZeroAppPage();
        zeroAppPage.ilkSignInButonu.click();

        // 3. Login kutusuna “username” yazin
        zeroAppPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroUsername"));

        // 4. Password kutusuna “password” yazin
        zeroAppPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroPassword"));

        // 5. Sign in tusuna basin
        zeroAppPage.signInButonu.click();

        // 6. back tusuna basin, Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroAppPage.onlineBankingLinki.click();
        zeroAppPage.payBillsLinki.click();

        // 7. “Purchase Foreign Currency” tusuna basin
        zeroAppPage.purchaseFCurrencyElementi.click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        //* dropdown menusunun secim yapabilmek icin;
        Select select = new Select(zeroAppPage.pcCurrencyDropdown);
        //*1-select objesi olusturuyorduk icine de bizim dropdown webelementimizi yaziyoruz
        select.selectByValue("EUR"); //sonra EUR olarak secimini yaptik
        // drop down oldugunu taginin select olmasindan anlıyoruz.

        //*simdi bu sectigimizin gercekten de EUR oldugunu test etmemiz gerekiyor
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert(); //softAssert objesi olustur

        String actualSecilmisOpsiyon = select.getFirstSelectedOption().getText();
        //SecilmisOpsiyon'u select objesinden getFirstSelectedOption()
        // getText() onun  uzerindeki yaziyi aliyordu
        String expectedSecilecekOpsiyon = "Eurozone (euro)";

        softAssert.assertEquals(actualSecilmisOpsiyon,expectedSecilecekOpsiyon,"secilen opsiyon Eurozone degil");
        // once actual sonra excepted son olarak da message

        // 10. soft assert kullanarak DropDown listesinin su secenekleri
        // oldugunu test edin "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
        // "Thailand (baht)"
        String[] dropdownElementleriArr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedDropdownElementleriList = Arrays.asList(dropdownElementleriArr);
        //Arrays classindan asList methodunu kullanarak bu arr'i
        // listeye cevirip kaydettim

        List<WebElement> dropdownElementleriList = select.getOptions();
        //*select objesi uzerinden getOptions() yaptim bu bana web element olarak
        //*dropdown'daki butun opsiyonlari getiriyordu.
        //*web element olarak getirdigi icin
        //*bende onu web elementlerden olusan bir liste olarak kaydettim.

        //*expetced olan String'lerden olusuyor, actual olan web elementten olusuyor
        //*bunlari karsilastiramayiz. onun icin once
        //*webelementlerden olusan actual listeyi
        //*stringlerden olusan bir actual listeye dondurmem lazim
        //*bunu da for each ile yaptim

        /*
        List<String> actualDropdownOpsiyonlariList = new ArrayList<>();

        for (WebElement each: dropdownElementleriList
             ) {
            actualDropdownOpsiyonlariList.add(each.getText());
        }
         */

        List<String> actualDropdownOpsiyonlariList = ReusableMethods.stringListeCevir(dropdownElementleriList);

        softAssert.assertEquals(actualDropdownOpsiyonlariList,expectedDropdownElementleriList,"dropdown opsiyonlari istenen sekilde degil");
        // once actual sonra excepted son olarak da message

        softAssert.assertAll(); // bunu yazmazsam test yapmaz

        Driver.closeDriver();
    }
}
