package tests.day09_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBase_BeforeAfter {
    Set<Cookie> cookies;
    int index;

    @Test
    public void test(){

        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        cookies = driver.manage().getCookies();

        index = 1;

        for (Cookie eachCookie : cookies){

            System.out.println(index + ". cookie " + eachCookie);
            index++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookiesSayi = 5;
        int actualCookiesSayi = cookies.size();

        Assert.assertTrue(actualCookiesSayi>expectedCookiesSayi);


        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieDegeri = "USD";
        String actualCookieDegeri = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("En sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        cookies = driver.manage().getCookies();
        boolean cikolataliVarmi = false;

        for (Cookie eachCookie : cookies){

            if (eachCookie.getValue().equals("cikolatali")){
                cikolataliVarmi = true;
                break;
            }

        }

        Assert.assertTrue(cikolataliVarmi);

        // 2.yontem olarak, cookie seti, ekledigimiz cookie'i iceriyor mu diye test edelim
        Assert.assertTrue(cookies.contains(yeniCookie));


        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        cookies = driver.manage().getCookies();

        boolean skinVarmi = false;

        for (Cookie eachCookie : cookies){

            if (eachCookie.getValue().equals("skin")){
                skinVarmi = true;
                break;
            }

        }

        Assert.assertFalse(skinVarmi);


        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        Assert.assertEquals(0,cookies.size());

    }
}
