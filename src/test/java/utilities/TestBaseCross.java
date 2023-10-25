package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {
    protected WebDriver driver;

    //*@Parameters xml'in buraya parametre gondermesine izin veriyor
    @Parameters("browser")
    @BeforeMethod
    //*methoddan once xml'den gelen browser'a uygun olarak gidip
    //*DriverCross'u olusturuyor ve geliyor.
    public void setUp(@Optional String browser){

        driver= DriverCross.getDriver(browser);
    //*getDriver(browser)'in icindeki broswer xml'den gelen browser
    //*xml'den browser bilgisini  DriverCross'a yollayıp ona uygun bir driver
        // *olusturtup onu da bizim kucuk driver'a yukluyor.


    }

    @AfterMethod
    public void tearDown(){

        DriverCross.closeDriver();
    }
}
