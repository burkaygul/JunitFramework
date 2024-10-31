package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;
import utilities.TestBase_BeforeAfterClass;

public class C01_JsAlerts extends TestBase_BeforeAfterClass {

    //3 test method'u olusturup asagidaki gorevi tamamlayin


    @Test
    public void alertTest() {
        //1. Test

        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("(//*[@class='j-button'])[1]")).click();

        ReusableMethods.bekle(3);

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedText = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedText, actualText);


        //	-  OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(2);
    }


    @Test
    public void confirmTest() {
        //2.Test
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("(//*[@class='j-button'])[2]")).click();

        ReusableMethods.bekle(2);
        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();
        ReusableMethods.bekle(2);

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You clicked: Cancel";

        Assert.assertEquals(expectedText, actualText);

    }


    @Test
    public void promptAlert() {
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("(//*[@class='j-button'])[3]")).click();

        //	- Cikan prompt ekranina "Rasit" yazdiralim
        driver.switchTo().alert().sendKeys("Rasit");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //	- Cikan sonuc yazisinin Rasit icerdigini test edelim

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "Rasit";

        Assert.assertTrue(actualText.contains(expectedText));
    }
}

