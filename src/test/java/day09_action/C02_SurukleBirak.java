package day09_action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_SurukleBirak extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement acceptableButonu = driver.findElement(By.id("draggable2"));
        WebElement hedefalanElement = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(acceptableButonu,hedefalanElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        ReusableMethods.bekle(2);
        String expectedYazi = "Dropped!";

        String actualYazi = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();

        Assertions.assertEquals(actualYazi,expectedYazi);


        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(2);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notacceptableButonu = driver.findElement(By.id("draggable-nonvalid2"));
        hedefalanElement = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notacceptableButonu,hedefalanElement).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        String expectedDropElementi = "Drop Here";
        String actual = driver.findElement(By.xpath("//*[text()='Drop Here']")).getText();

        Assertions.assertTrue(actual.contains(expectedDropElementi));

    }

}
