package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
     JUnit'de WebDriver objesi TestBase'den geliyordu

     TestNG extends ile baglanma zorunlulugunu ortadan kaldirmak
     ve testi yazanlara daha fazla kontrol imkani vermek icin
     TestBase yerine Driver class'inda static 2 method ile
     driver olusturma ve kapatma islemlerini yapmayi tercih etmistir
     */

    private Driver(){
        // Bu constructor default constructor ile ayni islevi yapan parametresiz constructor'dir
        // buna erisimi kontrol edebilecegimiz icin bu constructor'i olusturduk
        //day17 C03 'le alakali
    }

    static WebDriver driver; // biz deger atamadigimiz icin Java default olarak null point eder
    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

        if (driver == null){

            switch (browser){

                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }


        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null; // kapattiktan sonra da driver'i null olarak isaretlesin
                        // ki sonraki calismalarda yeniden acilsin
        }
    }
/*
16.dersle ilgili

static WebDriver driver; //biz  deger atamadigimiz icin Java default olarak null point eder
public static WebDriver getDriver(){

WebDriverManager.chromedriver().setup();

if(driver == null){ // driver null olarak isaretlenmis ise
driver = new ChromeDriver(); // driver'a yeni deger ata
                            // artik driver null olmasin new ChromeDriver() olsun
}

class ilk calıstıgında once static seyleri halledecegi icin driver null olarak isaretlenir
getDriver() methodu'nu ilk kullanıldıgında driver'i null olarak gorecek
bu andan itibaren driver'imizin degeri ChromeDriver

sonraki seferlerde getDriver() methodu calisinca driver null olmadigindan
yeniden driver olusturmayacak.


 */
}
