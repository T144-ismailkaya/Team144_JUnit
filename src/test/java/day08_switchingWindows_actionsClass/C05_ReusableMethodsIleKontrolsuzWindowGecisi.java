package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_ReusableMethodsIleKontrolsuzWindowGecisi extends TestBaseEach {

    @Test
    public void test01() {

        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

        /*
            Birden fazla window acildiginda
            acilan window'larin WHD'lerini onceden bilmemiz MUMKUN DEGIL
            ama gecmek istedigimiz window'un TITLE veya URL'ini BILIYORUZ
         */

        String hedefUrl = "https://testotomasyonu.com/category/7/products";

        //Electronics sayfasinin acildigini test edin
        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/category/7/products");

        String expectedUrl ="https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

        //Ilk actiginiz addremove sayfasinin oldugu window’a donun
        hedefUrl = "https://testotomasyonu.com/addremove/";

        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/addremove/");

        //Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }
}
