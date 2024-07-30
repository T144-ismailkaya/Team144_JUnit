package day13_javascriptExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_JavascriptExecutor extends TestBaseEach {

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(3);
        // 300 pixel aşağıya inin

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("window.scrollBy(0, 300)");
        ReusableMethods.bekle(3);

        // 500 pixel daha inin
        jse.executeScript("window.scrollBy(0, 500)");
        ReusableMethods.bekle(3);
        // jse ile axe ürününe click yapın

        WebElement axeElement = driver.findElement(By.xpath("//*[text()=' Axe Long Lasting Bodyspray']"));

        jse.executeScript("arguments[0].click();",axeElement);
        ReusableMethods.bekle(3);

        // product description butonu ekranın ortasına gelecek şekilde , butona scrool yapın

        WebElement productButonu = driver.findElement(By.xpath("(//*[@rel='prd-detail'])[1]"));

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",productButonu);
        ReusableMethods.bekle(3);

        // jse alert oluşturup "JUnit BITTI" yazdirin

        jse.executeScript("alert('JUnit BITTI');");
        ReusableMethods.bekle(5);
    }

}
