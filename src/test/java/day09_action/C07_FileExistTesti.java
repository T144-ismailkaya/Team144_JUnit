package day09_action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C07_FileExistTesti {

    @Test
    public void test01() {

        /*
            Selenium WebDriver adindan da anlayacagimiz uzere Web'de calisir
            bilgisayarimizdaki local dosyalara erisemez

            Eger testimizi gerceklestirirken
            Local'de bulunan bir dosyaya erismek gerekirse
            Java imdada yetisir

            Java'nin bilgisayarimizdaki bir dosyaya erisebilmesi icin
            dosya yoluna ihtiyaci vardir


         */

        String dosyaYolu = "C:\\Users\\ismai\\Downloads\\sample.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Projemizde day09 package'inda sample.png dosyasi bulundugunu test edin

        String dosyaYolu2 = "src/test/java/day09_action/sample.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu2)));

    }
}
