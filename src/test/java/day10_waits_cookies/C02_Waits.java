package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class C02_Waits extends TestBaseEach {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    WebDriver driver;

    @Test
    public void implicitWaitTest(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[@onclick='swapInput()']")).click();

        // Şimdiki yapacağımız beklemeye imlicitwait birşey yapamaz
        // çünkü imlicitWait sayfanın yüklenmesine veya webDriverin locate edilmesine bakmaz
        ReusableMethods.bekle(3);

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textbox.isEnabled());
        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement element = driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(element.isDisplayed());

        driver.quit();
    }

    @Test
    public void explicitWaitTest(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[@onclick='swapInput()']")).click();

        // explicitWait kullanabilmek icin
        // 1.adim bir wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // 2.adim EGER MUMKUNSE kullanacagimiz webelementi locate edin
        //        bizim kullanacagimiz textBox zaten locate edildi

        // 3.adim wait objesi ile baslayip, beklenecek kosulu tanimlayin
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        // artik texBox'in enable oldugunu test edebiliriz
        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textbox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement element = driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(element.isDisplayed());

        driver.quit();
    }

}
