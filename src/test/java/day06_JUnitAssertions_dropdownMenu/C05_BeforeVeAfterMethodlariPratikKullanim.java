package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

public class C05_BeforeVeAfterMethodlariPratikKullanim extends TestBaseEach {

    @Test
    public void urlTest(){
        driver.get("https://www.testotomasyonu.com");

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));

    }
}
