package tests.day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;
import java.util.Set;

public class C01_SwitchingWindows extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String actualText = driver.findElement(By.tagName("h2")).getText();
        String expectedText = "Add/Remove Elements";

        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "Test Otomasyonu";

        Assert.assertEquals(expectedTitle,actualTitle);



        // 1. adim click yapmadan ilk window'un WHD'ini kaydedelim
        String ilkWHD = driver.getWindowHandle();

        // 2. click yapalim
        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();


        // link'e tikladigimizda kontrolumuz disinda yeni bir tab acildigi icin
        // o tab'a gecebilmek icin WindowhandleDegerini bulmaliyiz


        // 3.click'den sonra 2 window olacagi icin, iki WHD olur
        //   bir Set olusturup 2 WHD'ini kaydedelim
        Set<String> WHDs = driver.getWindowHandles();
        String ikinciWindowWHD ="";

        // 4. bir for-each loop ile Set'deki iki WHD'den
        //    ilk sayfanin WHD'ne esit olmayani, ikinciWindowWHD olarak kaydedelim

        for (String eachWHD : WHDs
        ){
            if ( ! eachWHD.equals(ilkWHD)){
                ikinciWindowWHD = eachWHD;
            }
        }

        // 5. buldugumuz ikinciWindowWHD'ni kullanarak ikinci window'a gecelim
        driver.switchTo().window(ikinciWindowWHD);


        //● Electronics sayfasinin acildigini test edin

        actualTitle = driver.getTitle();
        expectedTitle = "Test Otomasyonu - Electronics";

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Bulunan urun sayisinin 16 olduğunu test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        Assert.assertEquals(expectedUrunSayisi,actualUrunSayisi);


        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkWHD);


        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(2);

    }



    }
