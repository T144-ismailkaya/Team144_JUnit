package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class C03_Waits extends TestBaseEach {

    WebDriver driver;
    @Test
    public void implicitWaitTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        ReusableMethods.bekle(3);
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement message = driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(message.isDisplayed());
        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        ReusableMethods.bekle(3);
        //5. It’s back mesajinin gorundugunu test edin
        Assertions.assertTrue(message.isDisplayed());

        driver.quit();
    }

    @Test
    public void explicitWaitTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        ReusableMethods.bekle(3);
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        // 1.adim wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        // 2.adim MUMKUNSE kullanacagimiz webElementi locate edin
        //   Eger mumkun degilse 2.ve 3.adimi birlestirecegiz
        //   bize kullanacagimiz webElementin locate bilgileri lazim
        //   xpath ==> "//*[text()=\"It's gone!\"]"

        // 3.adim locate bilgilerini kullanarak
        //   locate ve beklenecek islemi birlikte tanimlayin

        WebElement message =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));

        // 78.satirda its gone yazisinin ortaya cikmasini bekledik ve locate ettik
        // artik testimizi yapabiliriz

        Assertions.assertTrue(message.isDisplayed());


        //4. Add buttonuna basin
        //5. It’s back mesajinin gorundugunu test edin

        // 1. adim wait objesi olustur (yukarda olusturulldugu icin yenisine gerek yok)

        // 2.adim mumkunse kullanacagimiz elementi locate edin
        //        kullanacagimiz element daha onceden it's gone olan element ile ayni
        //        ama HTML element degistigi icin ayni element olarak dusunemeyiz
        //        bizim kullanmak istedigimiz It's back elementini
        //        locate etmemiz mumkun olmadigindan 2.ve 3.adimi birlestirelim
        //        xpath ==> "//*[text()=\"It's back!\"]"

        // 3.adim bekleme ve locate'i birlikte yapalim


        message =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));


        Assertions.assertTrue(message.isDisplayed());

        driver.quit();
    }

}
