package tests.day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C04_SagClick extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElement = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlanElement).perform();



        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";

        Assert.assertEquals(expectedAlertText,actualAlertText);
        ReusableMethods.bekle(2);



        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();


        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        ReusableMethods.switchWindow(driver,"https://elementalselenium.com/");

        String actualTagText = driver.findElement(By.tagName("h1")).getText();
        String expectedTagText = "Elemental Selenium";

        Assert.assertEquals(expectedTagText,actualTagText);


    }
}

