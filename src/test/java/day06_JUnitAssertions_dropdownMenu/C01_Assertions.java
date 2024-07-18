package day06_JUnitAssertions_dropdownMenu;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_Assertions {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void driverKapatma() {
        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void testotomasyonuTesti() {

        driver.get("https://www.testotomasyonu.com");
        String expectedUrlIcerik = "testotomasyonuPPPPP";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Testotomasyonu Url testi PASSED");
        } else {
            System.out.println("Testotomasyonu Url testi FAİLED");
        }

    }

    @Test @Disabled
    public void wisequarterTesti() {

        driver.get("https://www.wisequarter.com");
        String expectedUrlIcerik = "wisequarterPPPPP";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("WiseQuarter Url testi PASSED");
        } else System.out.println("WiseQuarter Url testi FAİLED");

    }

    @Test
    public void youtubeTesti() {

        driver.get("https://www.youtube.com");
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Actual Url expected içeriği barındırmıyor");

    }
}
