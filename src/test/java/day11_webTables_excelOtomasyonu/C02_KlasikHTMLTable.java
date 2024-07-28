package day11_webTables_excelOtomasyonu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C02_KlasikHTMLTable extends TestBaseEach {

    @Test
    public void test01() {

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2. Web table tum body’sini yazdirin
        System.out.println("===============TBODY===============");
        WebElement tumbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbody.getText());
        System.out.println("===============TBODY===============");

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedYazi = "Comfortable Gaming Chair";
        String actualTbodyYazisi = tumbody.getText();

        Assertions.assertTrue(actualTbodyYazisi.contains(expectedYazi));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        int sayi = 5;
        int actualSayi = satirSayisi.size();

        Assertions.assertEquals(actualSayi, sayi);

        //5. Tum satirlari yazdirin
        for (int i = 0; i < satirSayisi.size(); i++) {

            System.out.println(i + 1 + ".satir  ==> \n" + satirSayisi.get(i).getText());

        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> ucuncuSutunList = driver.findElements(By.xpath("//tbody//tr[3]/td"));
        int sutunSayi = 4;
        int actualSutunSayi = ucuncuSutunList.size();

        Assertions.assertEquals(actualSutunSayi, sutunSayi);

        //7. 3.sutunu yazdirin
        List<WebElement> fiyatlar = driver.findElements(By.xpath("//tbody//tr[*]/td[3]"));
        System.out.println(ReusableMethods.getStringList(fiyatlar)); //[$399.00, $40.00, $99.00, $39.00, $15.00]

        //8. Tablodaki basliklari yazdirin
        WebElement headerTumBasliklar = driver.findElement(By.xpath("//thead"));
        System.out.println(headerTumBasliklar.getText()); //Produt Name Category Price Actions

        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        getCell(3,3);

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedUrunIsmi = "Furniture";
        String actualUrunIsmi = getCell(4,2);

        Assertions.assertEquals(actualUrunIsmi,expectedUrunIsmi);


    }

    public String getCell(int satir, int sutun) {

        //tbody/tr[*]/td[*]
        String xpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";
        WebElement element = driver.findElement(By.xpath(xpath));

        System.out.println(element.getText());

        return element.getText();
    }

}
