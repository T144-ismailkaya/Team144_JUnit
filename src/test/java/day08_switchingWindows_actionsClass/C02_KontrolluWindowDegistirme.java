package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_KontrolluWindowDegistirme extends TestBaseEach {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com ");
        System.out.println("Anasayfa : "+driver.getCurrentUrl());
        System.out.println("Anasayfa : "+driver.getWindowHandle());
        String ilkWindowWhd = driver.getWindowHandle();

        // Yeni bir tab olusturup electronics linkine tiklayin

        /*
            EGER seleniumda yeni bir TAB(sekme) oluşturmak istersek
            driver.switchTo().newWindow() kullanabiliriz
            bu method kullanıldığında 4 önemli noktaya DİKKAT ETMEMİZ gerekir
            1- driver yeni açılan windowa otomatik olarak geçer
            2- yeni window boş olarak gelir
            3- açılan yeni window üzerinden window.navigate() methodu KULLANILAMAZ
               anasayfaya back ile dönemeyiz
            4- driver.switchTo().newWindow() yaptığımızda yeni window boş olarak geldiği için
               anasayfaya tekrar gidip electronics tıklamamız gerek
         */

        driver.switchTo().newWindow(WindowType.TAB);

        System.out.println("Yeni tab açıldığında : "+driver.getCurrentUrl());
        //Yeni tab açıldığında : about:blank
        System.out.println("Yeni tab açıldığında : "+driver.getWindowHandle());
        //Yeni tab açıldığında : 049CB815D7B34E068D00A246C3A0461B
        System.out.println("Yeni tab açıldığında tüm WHD değerleri : "+driver.getWindowHandles());
        //049CB815D7B34E068D00A246C3A0461B
        ReusableMethods.bekle(1);

        System.out.println("=================================");
        driver.get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        System.out.println("Electonics linkine basınca : "+driver.getCurrentUrl());
        //Electonics linkine basınca : https://www.testotomasyonu.com/category/7/products
        System.out.println("Electonics linkine basınca : "+driver.getWindowHandle());
        //Electonics linkine basınca : 40859FFD023CD9DBBE686159D164B140
        System.out.println("Electonics linkine basınca tüm WHD: "+driver.getWindowHandles());
        //Electonics linkine basınca tüm WHD: [8FC30E7300BD1AD49476E1E03349AA5E, 40859FFD023CD9DBBE686159D164B140]
        ReusableMethods.bekle(1);
        String ikinciWindowWhd = driver.getWindowHandle();
        System.out.println("=================================");

        // Yeni bir window'da wisequarter.com'a gidin

        driver.switchTo().newWindow(WindowType.TAB);

        System.out.println("3'üncü tab açıldığında : "+driver.getCurrentUrl());
        //Yeni tab açıldığında : about:blank
        System.out.println("3'üncü tab açıldığında : "+driver.getWindowHandle());
        //Yeni tab açıldığında : 049CB815D7B34E068D00A246C3A0461B
        System.out.println("3'üncü tab açıldığında tüm WHD değerleri : "+driver.getWindowHandles());
        //049CB815D7B34E068D00A246C3A0461B
        ReusableMethods.bekle(1);
        String ucuncuWindowWhd = driver.getWindowHandle();
        driver.get("https://www.wisequarter.com");
        System.out.println("=================================");

        System.out.println("Birinci window açıldığında Window WHD : "+ilkWindowWhd);
        System.out.println("İkinci window açıldığında Window WHD : "+ikinciWindowWhd);
        System.out.println("Üçüncü window açıldığında Window WHD : "+ucuncuWindowWhd);

        // testotomasyonu anasayfanin acik oldugu window'a donun ve
        // anasayfada oldugunuzu test edin

        driver.switchTo().window(ilkWindowWhd);
        String expectedTestotomasyonu = "https://www.testotomasyonu.com/";
        String actualTestotomasyonu = driver.getCurrentUrl();

        Assertions.assertEquals(actualTestotomasyonu,expectedTestotomasyonu);
        ReusableMethods.bekle(2);

        // electronics urunlerin oldugu window'a gidin
        // Home/Electronics yazdigini test edin

        driver.switchTo().window(ikinciWindowWhd);
        WebElement seciliKategoryElementi = driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori = "Electronics";
        String actualSeciliKategori = seciliKategoryElementi.getText();

        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);
        ReusableMethods.bekle(2);

        // wisequarter'in acik oldugu window'a gidin
        // url'in wisequarter icerdigini test edin

        driver.switchTo().window(ucuncuWindowWhd);
        String expectedWiseQuarter = "wisequarter";
        String actualWiseQuarter = driver.getCurrentUrl();

        Assertions.assertTrue(actualWiseQuarter.contains(expectedWiseQuarter));
        ReusableMethods.bekle(2);

    }
}
