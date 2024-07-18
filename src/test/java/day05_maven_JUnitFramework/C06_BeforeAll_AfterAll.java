package day05_maven_JUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C06_BeforeAll_AfterAll {

    // 3 farkli test method'u olusturup, asagidaki 3 gorevi yerine getirin
    // 1- testotomasyonu anasayfaya gidin ve dogru sayfaya gittiginizi test edin
    // 2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin ve urun isminde case sensitive olmadan phone bulundugunu test edin

    /*
        JUnit'de @Test method'larinin hangi sira ile calisacagi
        ongorulemez ve kontrol edilemez
        Eger test method'larinin belirli bir sirada calismasini istersek
        @Test method isimlerini test01, test02... gibi ayarlayabiliriz

        @BeforeAll ve @AfterAll method'lari static OLMAK ZORUNDADIR
     */


    static WebDriver driver;
    static List<WebElement> urunlerListesi;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // 1- testotomasyonu anasayfaya gidin ve dogru sayfaya gittiginizi test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlTesti = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlTesti)) {
            System.out.println("Sayfa ulaşılabilirlik testi PASSED");
        } else System.out.println("Sayfa ulaşılabilirlik testi FAİLED");

    }

    @Test
    public void test02() {
        // 2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
        WebElement testotomasyonuArrKutusu = driver.findElement(By.id("global-search"));
        testotomasyonuArrKutusu.sendKeys("phone" + Keys.ENTER);

        urunlerListesi = driver.findElements(By.className("prod-img"));

        if (urunlerListesi.size() > 0) {
            System.out.println("Urun bulunabilirliği testi PASSED");
        } else System.out.println("Urun bulunabilirliği testi FAİLED");

    }

    @Test
    public void test03() {
        // 3- ilk urunu tiklayin ve urun isminde case sensitive olmadan phone bulundugunu test edin
        urunlerListesi.get(0).click();

        String expectedUrunIcerigi = "phone";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualIsim = urunIsimElementi.getText().toLowerCase();


        if (actualIsim.contains(expectedUrunIcerigi)) {
            System.out.println("Urun ismi testi PASSED");
        } else System.out.println("Urun ismi testi FAILED");
    }


}