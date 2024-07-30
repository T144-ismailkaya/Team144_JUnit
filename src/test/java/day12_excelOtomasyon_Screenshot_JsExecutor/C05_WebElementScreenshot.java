package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBaseEach {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // logo elementinin screenshot'ini alin
        // tum sayfa screenshot ile webelement screenshot arasindaki fark
        // direk driver'i atadigimiz tss objesi yerine
        // istenen WebElement'i kullanarak screenshot almaktir

        // 1.adim kullanacagimiz WebElementi locate edip kaydedin
        WebElement logoElementi = driver.findElement(By.xpath("(//*[@alt='Logo'])[1]"));

        // 2.adim kaydedeceginiz dosyayi olusturun
        File webelementSS = new File("target/ekranGoruntuleri/webelementSS.png");

        // 3.adim webelementi kullanarak screenshot'i alip gecici dosyaya kaydedin
        File geciciDosya = logoElementi.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,webelementSS);



        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonuc yazisinin screenshot'ini alin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        ReusableMethods.getWebelementScreenshot(aramaSonucElementi);
    }

}
