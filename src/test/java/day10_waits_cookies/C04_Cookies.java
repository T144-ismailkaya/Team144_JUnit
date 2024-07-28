package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_Cookies extends TestBaseEach {

    @Test
    public void test01(){

        // facebook anasayfaya gidin
        driver.get("https://www.facebook.com");

        // eger isteniyorsa cookies kabul edin
        //driver.findElement(By.xpath("(//*[text()='Allow all cookies'])[2]")).click();

        // Tum cookie'leri yazdirin

        Set<Cookie> cookiesSeti = driver.manage().getCookies();
        int siraNo = 1;

        for (Cookie eachCookie :cookiesSeti
        ) {
            System.out.println(siraNo + ". cookie :  " + eachCookie);
            siraNo++;
        }

        // yeni bir cookie olusturun. Ismi : en sevdigim cookie  degeri : cikolatali cookie
        // ve bu cookie'yi facebook'a ekleyin

        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali cookie");
        driver.manage().addCookie(yeniCookie);
        System.out.println("=============================");
        cookiesSeti = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie eachCookie :cookiesSeti
        ) {
            System.out.println(siraNo + ". cookie :  " + eachCookie);
            siraNo++;
        }

        // ekledigimiz cookie'nin eklendigini test edin

        String expectedCookieValue = "cikolatali cookie";

        String actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();

        Assertions.assertEquals(expectedCookieValue,actualCookieValue);

        // ismi "_js_sb" olan cookie'yi silin

        driver.manage().deleteCookieNamed("_js_sb");

        // ismi "_js_sb" olan cookie'nin silindigini test edin
        // bunun icin iki yol kullanilabilir
        // 1- olmayan bir cookie'yi yazdirmak istersek exception verir
        //    exception olusuyorsa onu try catch ile kontrol alir
        //    exception olustuguna gore aranan cookie silinmistir diyebiliriz
        // 2- asagida cookie'leri yazdirdigimiz for-each loop'da
        //    ele aldigimiz her eachCookie'nin isminin aradigim cookie olup olmadigini kontrol ederim
        //    basta olusturacagimiz bir flag ile ile loop sonunda test yaparim

        System.out.println("=============================");
        cookiesSeti = driver.manage().getCookies();
        siraNo = 1;

        boolean jsSbCookieVarMi = false;

        for (Cookie eachCookie :cookiesSeti
        ) {
            System.out.println(siraNo + ". cookie :  " + eachCookie);
            if (eachCookie.getName().equals("_js_sb")){
                jsSbCookieVarMi = true;
            }
            siraNo++;
        }

        Assertions.assertFalse(jsSbCookieVarMi);

        // tum cookie'leri silin

        driver.manage().deleteAllCookies();

        // tum cookie'leri sildigimizi test edin

        cookiesSeti = driver.manage().getCookies();
        Assertions.assertTrue(cookiesSeti.isEmpty());


        ReusableMethods.bekle(3);


    }

}
