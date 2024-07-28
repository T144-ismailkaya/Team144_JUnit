package day11_webTables_excelOtomasyonu;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C01_KlasikHTMLTable extends TestBaseEach {

    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // butun basliklari yazdirin
        WebElement headerTumBasliklar = driver.findElement(By.xpath("//thead"));
        System.out.println(headerTumBasliklar.getText()); //Produt Name Category Price Actions

        // baslik satirindaki 2.basligi yazdirin
        System.out.println(driver.findElement(By.xpath("//thead/tr/th[2]")).getText());

        // tum basliklari bir liste olarak kaydedin
        List<WebElement> basliklarElemntleriList  = driver.findElements(By.xpath("//thead/tr/th"));
        List<String> basliklarList = ReusableMethods.getStringList(basliklarElemntleriList);
        System.out.println(basliklarList); //[Produt Name, Category, Price, Actions]

        // 4.basligi yazdirin
        //Elemnleri yazdırıken list kullandığımız için index'e göre hareket ederiz (indexler 0'dan başlar)
        System.out.println(basliklarList.get(3)); //Actions

        // tablodaki urunlerden 2.satir, 3.sutundaki bilgiyi yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText()); //$40.00

        // 3.satirdaki urunun butun bilgilerini yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody/tr[3]")).getText());
        //Medium 25 L Laptop Backpack
        //For Office/College/Travel (Black, Yellow)
        //Travel
        //$99.00 Go
    }

}
