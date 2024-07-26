package day09_action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_SagClick extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement drones = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.bekle(2);
        actions.contextClick(drones).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedYazi = "Tebrikler!... Sağ click yaptınız.";
        String actualYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(actualYazi,expectedYazi);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

    }

}
