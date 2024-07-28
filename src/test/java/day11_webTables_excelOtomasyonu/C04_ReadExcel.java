package day11_webTables_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void test01() throws IOException {

        // excel'e ulasip Sayfa1'de 8.satir 1.sutundaki datayi yazdiralim

        // 1.adim, Java ile dosyaya ulasabilmek icin dosya yolunu hazirlayalim
        String dosyaYolu = "src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3.excel dosyalari birden fazla sayfa icerebilen ozel yapilar oldugundan
        //   bunu apache.poi kullanarak bir workbook olarak kaydedelim
        Workbook workbook = new XSSFWorkbookFactory().create(fis);
        // gercek excel'deki bilgileri Java yardimi ile okuyup
        // bu class'da olusturdugumuz workbook'a yukledik
        // workbook exceldeki tum bilgilere sahip ama excel'in bir kopyasi

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // excel de Java gibi index kullanir ve index 0'dan baslar
        Row row8 = sayfa1.getRow(7);

        Cell data8ciSutun1ciData = row8.getCell(0);

        System.out.println(data8ciSutun1ciData); //Argentina

    }

    @Test
    public void test02() throws IOException {

        // excel'deki Sayfa1'de 15.satir 4. datasini yazdirin

        // Sayfa1'e kadar tum adimlari atmak zorundayiz

        String dosyaYolu = "src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = new XSSFWorkbookFactory().create(fis);

        // workbook olusturup excel'deki tum bilgileri workbook'a yukledik
        // bundan sonra workbook'da var olan bilgileri alacagiz, bunun icin get...() kullaniriz
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        System.out.println(sayfa1.getRow(14).getCell(3).toString());

        // 22.satir 3.sutundaki bilginin Bolivya oldugunu test edin

        String expectedData = "Bolivya";
        String actualData = sayfa1.getRow(21).getCell(2).toString();

        Assertions.assertEquals(expectedData,actualData);
    }

}
