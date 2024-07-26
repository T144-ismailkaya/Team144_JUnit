package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_WindowSayfaFarki extends TestBaseEach {

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getCurrentUrl()); //https://www.testotomasyonu.com/
        System.out.println(driver.getWindowHandle()); //F4ABE527E3AB2EB3D6F23896135F4263
        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        // Electronics linkine tiklayalim
        System.out.println(driver.getCurrentUrl()); //https://www.testotomasyonu.com/category/7/products
        System.out.println(driver.getWindowHandle()); //F4ABE527E3AB2EB3D6F23896135F4263
        ReusableMethods.bekle(1);

        // ilk urune click yapalim
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]")).click();
        System.out.println(driver.getCurrentUrl()); //https://www.testotomasyonu.com/category/7/products
        System.out.println(driver.getWindowHandle()); //F4ABE527E3AB2EB3D6F23896135F4263
        ReusableMethods.bekle(1);
        /*
            Aynı windowda yeni sayfalar açtığımız için
            driver.navigate().back ile dönebiliriz
         */
        driver.navigate().back();
        System.out.println("ilk back'teki url : "+driver.getCurrentUrl()); //https://www.testotomasyonu.com/category/7/products
        System.out.println("ilk back'teki window WHD : "+driver.getWindowHandle()); //F4ABE527E3AB2EB3D6F23896135F4263
        ReusableMethods.bekle(1);

        driver.navigate().back();
        System.out.println("ikinci back'teki url : "+driver.getCurrentUrl()); //https://www.testotomasyonu.com/category/7/products
        System.out.println("ikinci back'teki window WHD : "+driver.getWindowHandle()); //F4ABE527E3AB2EB3D6F23896135F4263
        ReusableMethods.bekle(1);

    }
}
