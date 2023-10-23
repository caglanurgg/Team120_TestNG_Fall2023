package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    /*
        TestNG'de page class'lari
        surekli kullandigimiz bir sayfa/webSitesi'ndeki
        locate'leri ve
        ilgili sayfada kullanilacak login gibi basit method'lari icerir

        TestNG page class'larindaki locate'lere erisim icin
        Test class'larinda page class'indan obje olusturulmasini benimsemistir.
     */

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // bu AmazonPage sayfasinda driver olarak benim olusturdugum
    // Driver classında getDriver ile olusturdugum driver'i kullan
    // artik otomatik olarak AmazonPage'den bir obje olusturuldugunda
    // Amazon constructor'i calisacak Amazon constructor'i calistiginda da
    // bu classda gecerli driver olarak Driver.getDriver() kullan diyecek

    // benim istedigim constructor calissin default constructor calismasin diye
    // buraya bir tane parametresiz constructor olusturuyorum
    // farkli package'larda oldugum icinde public yapmam lazim

    @FindBy(id ="twotabsearchtextbox") // artik driver.findElement() yok
    public WebElement aramaKutusu; // artik bi daha arama kutusunu locate etmek yok

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//span[@class='a-size-large product-title-word-break']")
    public WebElement ilkUrunIsimElementi;
}
