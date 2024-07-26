package day09_action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseEach;

public class C03_MoveToElement extends TestBaseEach {

    @Test
    public void test(){

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"))).perform();

        //3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[text()='Boys']")).click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();

        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expectedIsim = "Boys Shirt White Color";
        String actualurunIsmi = driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']")).getText();

        Assertions.assertEquals(expectedIsim,actualurunIsmi);

    }

}
