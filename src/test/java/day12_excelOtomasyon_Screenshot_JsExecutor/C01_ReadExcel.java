package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        //Gerekli ayarlamaları yapıp ulkeler excelindeki Sayfa1'e gidin
        String dosyaYolu = "src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1)); //Başkent (İngilizce)
        // - 1.satirdaki 2.hucreyi bir string degiskene atayın ve değişkeninin Başkent (İngilizce) olduğunu doğrulayın
        String expectedYazi = "Başkent (İngilizce)";
        String actualYazi = sayfa1.getRow(0).getCell(1).toString();

        Assertions.assertEquals(expectedYazi,actualYazi);
        // - 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        String expectedBaskent = "Kabil";
        String actualBaskent = sayfa1.getRow(1).getCell(3).toString();

        Assertions.assertEquals(expectedBaskent,actualBaskent);
        // - Ulke sayisinin 190 oldugunu test edin
        int expectedUlkeSayisi = 190;
        int actualUlkeSayisi = sayfa1.getLastRowNum();
        // getLastRowNum() bize index verdiği için 191 satır kullanıldığı halde 190 verecek
        // eger kaç satır kullanıldığını bulmak istersek buna 1 eklememiz gerekir
        // Ancak en başta başlık oldugundan,
        // ulke sayısını bulmak için kullanılan satır sayısından 1 çıkarmak gerekiyor

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);
        // - Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKulanilanSatirSayisi = 191;
        int actualKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKulanilanSatirSayisi,actualKullanilanSatirSayisi);
        // kullanilan satır sayisini bulmak için
        // sayfa1.getLastRowNum() + 1 de kullanılabilir
        // ANCAK arada boş satır varsa
        // sayfa1.getPhysicalNumberOfRows() boş satırları görmez

        // - Ingilizce ismi Netherland olan ulkenin
        // baskentinin turkce Amsterdam oldugunu test edin

        String satirdakiTurkceBaskentIsmi = "";
        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {
            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")) {
                satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();
                break; // İlgili ülkeyi bulduktan sonra döngüden çıkmak performansı artırabilir
            }
        }
        Assertions.assertEquals("Amsterdam", satirdakiTurkceBaskentIsmi);

        //- Turkce baskent isimlerinde Ankara bulundugunu test edin

        // Bu soruyu iki türlü çözebiliriz
        // 1- for loop ve flag oluşturalım

        boolean ankaraVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {
            satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            if (satirdakiTurkceBaskentIsmi.equalsIgnoreCase("Ankara")){
                ankaraVarMi = true;
                break;
            }
        }
        Assertions.assertTrue(ankaraVarMi);

        // 2.yol ingilizce ülke isimini Key baskent ismini value olarak seşip
        // tüm ülkelerin bu iki bilgisini bir map'e ekleyelim

        Map<String,String> ulkelerMap = new TreeMap<>();

        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiTurkceBaskentIsmi);


        }

        System.out.println(ulkelerMap);

        // ulkelerMap inde baskent olarak ankara bulunduğunu test edin
        Assertions.assertTrue(ulkelerMap.containsValue("Ankara"));
        // ulkelerMap inde baskent olarak berlin bulunduğunu test edin
        Assertions.assertTrue(ulkelerMap.containsValue("Berlin"));
        // ulkelerMap inde ülke olarak Nepal bulunduğunu test edin
        Assertions.assertTrue(ulkelerMap.containsKey("Nepal"));



    }

}
