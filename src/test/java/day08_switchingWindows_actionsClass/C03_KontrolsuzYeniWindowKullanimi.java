package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;
import java.util.Set;

public class C03_KontrolsuzYeniWindowKullanimi extends TestBaseEach {

    @Test
    public void test01() {

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkWHD = driver.getWindowHandle();
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement addremoveYazisi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = addremoveYazisi.getText();

        Assertions.assertEquals(actualYazi,expectedYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

        //● Electronics sayfasinin acildigini test edin
        //İlk önce driver'i kontrolsüz açılan 2.window'a geçirmeliyiz

        Set<String> tumwindowlarinWHD = driver.getWindowHandles();

        String ikinciWHD = "";

        for (String eachWHD : tumwindowlarinWHD) {

            if ( ! eachWHD.equals(ilkWHD) ){
                ikinciWHD = eachWHD;
            }

        }

        driver.switchTo().window(ikinciWHD);
        String expectedElectronicsLink = "https://testotomasyonu.com/category/7/products";
        String actualElectonicsLink = driver.getCurrentUrl();

        Assertions.assertEquals(actualElectonicsLink,expectedElectronicsLink);


        //● Bulunan urun sayisinin 16 olduğunu test edin
        List<WebElement> urunSayisi = driver.findElements(By.className("prod-img"));

        int expectedSayi = 16;

        Assertions.assertEquals(urunSayisi.size(),expectedSayi);

        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun
        driver.switchTo().window(ikinciWHD);

        //● Url’in addremove icerdigini test edin
        driver.switchTo().window(ilkWHD);
        String expectedURLYazi = "addremove";
        String actualURLYazi = driver.getCurrentUrl();

        Assertions.assertTrue(actualURLYazi.contains(expectedURLYazi));
        ReusableMethods.bekle(3);

    }
}
