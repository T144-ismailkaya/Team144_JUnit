package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C03_TumSayfaScreenshot extends TestBaseEach {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin
        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = driver.findElement(By.className("product-count-text"))
                .getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

        // Eger tum sayfa screenshot almak isterseniz 4 adim atmamiz gerekiyor

        // 1.adim screenshot objesi olusturmak ve deger olarak driver'imizi atamak
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim screenshot'i kaydedecegimiz File'i olusturun
        File tumSayfaSS = new File("target/ekranGoruntuleri/tumSayfaSS.png");

        // 3.adim screenshot'i alip gecici bir dosyaya kopyalayalim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaSS);

        ReusableMethods.bekle(3);



    }

}
