package tests.day08_actions_faker_fileTestleri;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class C03_FileExist extends TestBase_BeforeAfter{

    @Test
    public void test01(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //2. logo.png dosyasını indirelim
        driver.findElement(By.linkText("boat.jpg")).click();

        ReusableMethods.bekle(7);
        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Java ile bir dosyanin bilgisayarimizda oldugunu test etmek icin
        // o dosyanin dosya yoluna ihtiyac duyariz

        String dosyaYolu = "C:\\Users\\Burkay9\\Downloads\\boat.jpg";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // masaustunde logo.png dosyasinin oldugunu test edelim

        dosyaYolu = "C:\\Users\\Burkay9\\Desktop\\boat.jpg";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
