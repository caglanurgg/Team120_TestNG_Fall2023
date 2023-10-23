package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

     /*
    Bir page sayfasini actiysak yapmamiz gereken ilk sey
    public olarak parametresiz constructor olusturmaktir.
    ve Driver'imizi bu classta kullanilmak uzere tanitmak
     */

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "login-email")
    public WebElement emailKutusu;

    @FindBy(id = "login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//div[@class='cookieButton']")
    public WebElement cookieAccept;


    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement basariliGirisElementi;

}
