package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_SwitchingWindows extends TestBaseEach {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        //Bu yazı elementi iframe içerisinde bulunduğu için ilk iframeye inceğiz

        WebElement elektronicsProductIframe = driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(elektronicsProductIframe);

        WebElement elecronicYazisi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(elecronicYazisi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement ilkUrunElementi = driver.findElement(By.id("pictext1"));

        String expectedDellCoreurunTesti = "DELL Core I3 11th Gen";
        String actualDellCoreurunTesti = ilkUrunElementi.getText();

        Assertions.assertEquals(actualDellCoreurunTesti,expectedDellCoreurunTesti);

        //4- Dell bilgisayar’a tiklayip
        ilkUrunElementi.click();

        // acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        // elemente tikladigimizda kontrolsuz olarak yeni window aciliyor
        // once yeni acilan window'a gecmemiz gerekir
        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/product/58");
        String expectedfiyatTesti = "$399.00";
        String actualfiyatTesti =  driver.findElement(By.id("priceproduct")).getText();

        Assertions.assertTrue(expectedfiyatTesti.contains(actualfiyatTesti));

        //5- Ilk window'a donun
        ReusableMethods.switchWindowByTitle(driver,"Test Otomasyonu");

        // ve Fashion yazisinin gorunur olduğunu test edin
        // Fashion yazisi iframe icinde oldugundan once iframe'e gecis yapalim
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        WebElement fashionYazisi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(fashionYazisi.isDisplayed());


    }
}
