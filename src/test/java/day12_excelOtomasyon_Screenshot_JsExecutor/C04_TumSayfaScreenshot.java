package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_TumSayfaScreenshot extends TestBaseEach {

    @Test
    public void test01(){

        // http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // ekran goruntusu alin
        ReusableMethods.getFullScreenshot(driver,"Zero anasayfa");

        // online banking menusune girin
        driver.findElement(By.xpath("//strong[text()='Online Banking']"))
                .click();

        // ekran goruntusu alin

        ReusableMethods.getFullScreenshot(driver,"Online banking");

        // tekrar ekran goruntusu alin

        ReusableMethods.getFullScreenshot(driver);

    }

}
