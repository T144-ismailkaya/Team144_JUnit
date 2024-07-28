package day11_webTables_excelOtomasyonu;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C03_KlasikOlmayanWebTable extends TestBaseEach {

    @Test
    public void test01() {

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//*[@role ='hrow']/*[@role='hdata']"));

        System.out.println(ReusableMethods.getStringList(baslikElementleriList));
        //[Product Name, Category, Price, Actions]

        //klasik HTML tablo olsaydi //thead/th

        //  3. 3.sutunun basligini yazdirin
        System.out.println(baslikElementleriList.get(2).getText()); // Price

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataElementleriList =
                driver.findElements(By.xpath("//*[@role ='tdata']"));

        System.out.println(ReusableMethods.getStringList(tumDataElementleriList));
        //  [DELL Core I3 11th Gen, Electronics, $399.00, Go,
        //   Medium 25 L Laptop Backpack, Electronics, $399.00, Go,
        //   Comfortable Gaming Chair, Furniture, $399.00, Go,
        //   Samsung White Smart Watch, Electronics, $40.00, Go,
        //   Men Sun Glasses, Men Fashion, $15.00, Go]

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("tablodaki data sayisi : " + tumDataElementleriList.size());
        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//*[@role ='trow']"));

        System.out.println("tablodaki satir sayisi : " + satirElementleriList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     web tablosunda sutun olmaz, herhangi bir satirdaki data sayisini yazdiralim

        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());


        //  8. Tablodaki 3.kolonu yazdirin
        //     web tablosunda sutun olmaz
        //     her satirdaki 3.datayi yazdiralim

        List<WebElement> ucuncuKolonElementleriList =
                driver.findElements(By.xpath("(//*[@role ='trow']) / *[@role ='tdata'][3]"));

        System.out.println(ReusableMethods.getStringList(ucuncuKolonElementleriList));
        // [$399.00, $399.00, $399.00, $40.00, $15.00]


        //  9. Tabloda " Category" si Men Fashion olan urunun fiyatini yazdirin

        for (int i = 1; i <= satirElementleriList.size(); i++) {
            //i.satirdaki kategori bilgisini alalim
            String satirdakiCategori = getCellData(i, 2);

            if (satirdakiCategori.equalsIgnoreCase("Men Fashion")) {
                System.out.println("istenen fiyat : " + getCellData(i, 3));
            }
            // istenen fiyat : $15.00

        }

        //10. Bir method olusturun, Test method'undan satir ve sutun verildiginde datayi dondursun

        System.out.println(getCellData(1, 1)); // DELL Core I3 11th Gen
        System.out.println(getCellData(2, 2)); // Electronics
        System.out.println(getCellData(4, 3)); // $40.00

    }

    public String getCellData(int satir, int sutun) {

        String istenenData = "";

        //    herhangi bir cell icin xpath :  //*[@role ='trow'][3] / *[@role='tdata'][1]

        String dinamikXpath = "//*[@role ='trow'][" + satir + "] / *[@role='tdata'][" + sutun + "]";

        istenenData = driver.findElement(By.xpath(dinamikXpath))
                .getText();

        return istenenData;
    }
}
