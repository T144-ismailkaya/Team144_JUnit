package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_WebElementScreenshot extends TestBaseEach {

    @Test
    public void test01(){

        //1- testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        //2- url'in testotomasyonu icerdigini test edin ve tum sayfa screenshot alin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.getFullScreenshot(driver,"Testotomasyonu_240929");

        //3- Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //4- Arama sonucunda urun bulunamadigini test edin
        //   ve arama sonuc yazisinin screenshot'ini alin

        WebElement aramaSonucYazisi = driver.findElement(By.className("product-count-text"));

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucYazisi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        ReusableMethods.getWebelementScreenshot(aramaSonucYazisi,"Nutella sonuc testi");

        //5- dress icin arama yapin
        aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress" + Keys.ENTER);

        //6- ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();

        //7- urun isminin dress icerdigini test edin ve screenshot'ini alin
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        ReusableMethods.bekle(1);
        String expectedUrunIcerik = "dress";
        String actualIsimKucukHarf = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsimKucukHarf.contains(expectedUrunIcerik));

        ReusableMethods.getWebelementScreenshot(ilkUrunIsimElementi,"Ilk urun isim testi");
    }

}
