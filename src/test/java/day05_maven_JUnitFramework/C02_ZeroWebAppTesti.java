package day05_maven_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ZeroWebAppTesti {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.id("signin_button")).click();

        WebElement userKutusu = driver.findElement(By.id("user_login"));
        userKutusu.sendKeys("username");

        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        driver.findElement(By.name("submit")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        WebElement amountKutusu = driver.findElement(By.id("sp_amount"));
        amountKutusu.sendKeys("200");

        driver.findElement(By.id("sp_date")).sendKeys("2024-07-16");

        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement mesajElementi = driver.findElement(By.id("alert_content"));

        String expectedMesaj = "The payment was successfully submitted.";
        String actualMesaj = mesajElementi.getText();

        if (actualMesaj.contains(expectedMesaj)){
            System.out.println("Mesaj içerik testi PASSED");
        }else System.out.println("Mesaj içerik testi FAİLED");

        ReusableMethods.bekle(5);
        driver.quit();
    }
}
