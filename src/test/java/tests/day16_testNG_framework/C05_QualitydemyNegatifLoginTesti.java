package tests.day16_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyNegatifLoginTesti {

    QualitydemyPage qualitydemyPage; // diger testlerde de kullanabileyim diye

    @Test(groups = {"smoke","regression"})
    public void gecersizPasswordTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");

        qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("12345");
        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(5);
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());

        Driver.closeDriver();
    }

    @Test(groups = {"smoke","e2e1"})
    public void gecersizEmailTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");

        qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys("alican@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");
        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(5);
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test(groups = {"e2e1","regression"})
    public void gecersizEmailPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/ ");

        qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys("alican@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("12345");
        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(5);
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    /*
    TestNG framework ile ilgili halletmemiz gereken bir tek Test Data'miz kaldi.
    adres
    gecerli email - gecersiz sifre
    gecersiz email - gecerli sifre
    gecersiz email - gecersiz sifre
    bunlar test datasi artik bunlari da bir kere kaydedecegiz bir daha onlarla ugrasmayacagiz
    mesela facebook'a git diyecegiz ama tekrar https://www.facebook.com/ yazmakla ugrasmayacagiz

    tamamiyla baska yerden yonetilen, tek bir yerden kontrol edilebilecegim
    test datalari ve locatorlar olacak.
     */
}
