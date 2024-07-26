package day07_JsAllerts_IFrame;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_JsAllerts extends TestBaseEach {

    @Test
    public void test01() {

         /*
            Eger acilan pop-up veya uyari locate edilebiliyorsa
            yani HTML kodlarina ulasabiliyorsak
            bu allert'e HTML alert denir ve
            tum HTML elementler gibi locate edip kullanilabilir
         */

        //YouTube anasayfasına gidin
        driver.get("https://www.youtube.com");

        //Cookies kabul edin

        //YouTube logosunun gorundugunu test edin
        WebElement ytIcon = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assertions.assertTrue(ytIcon.isDisplayed());

        ReusableMethods.bekle(5);

        //https://testotomasyonu.com/javascriptAlert sayfasina gidin
        driver.get("https://www.testotomasyonu.com/javascriptAlert");

        // Click For JS alert butonuna basin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        ReusableMethods.bekle(2);
        /*
            EGER bir alert ciktiginda, HTML kodlari goruntulenemiyorsa
            driver ile locate edip kullanamayiz

            Selenium'da driver method'lari icinde olan
            switchTo() bu tur durumlarda kullanilabilir

         */

        // alert'de cikan yazinin "I am a JS Alert" oldugunu test edin
        String expectedYaziTesti = "I am a JS Alert";
        String actualYaziTesti = driver.switchTo().alert().getText();

        Assertions.assertEquals(actualYaziTesti,expectedYaziTesti);


        // OK'e basarak alert'u kapatin
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);

    }
}
