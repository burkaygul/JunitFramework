package tests.day10_excelOtomasyon_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class C04_GetScreenshot extends TestBase_BeforeAfter {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);
        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);


        // arama sonuc sayfasinin screenshot'ini kaydedin

        // 1- takesScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- cekilen screenshot'i kaydedecegimiz dosyayi olusturalim

        File tumSayfaScreenshot = new File("target/screenshots/tumSayfaSS.jpeg");

        // 3- tss objesini kullanarak screenshot alip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        ReusableMethods.bekle(2);
    }
}