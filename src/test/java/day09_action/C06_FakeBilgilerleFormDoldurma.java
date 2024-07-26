package day09_action;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_FakeBilgilerleFormDoldurma extends TestBaseEach {

    @Test
    public void test01(){
        Faker faker = new Faker();
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[text()='Account'])[1]")).click();
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        String fakeMail = faker.internet().emailAddress();
        String fakeSifre = faker.internet().password();

        WebElement firstnameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));
        ReusableMethods.bekle(2);
        Actions actions = new Actions(driver);
        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //5- Kaydin olusturuldugunu test edin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        ReusableMethods.bekle(2);
        actions.click(emailKutusu)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement logoutButtonu = driver.findElement(By.xpath("//span[text()='Logout']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assertions.assertTrue(logoutButtonu.isDisplayed());
        logoutButtonu.click();
        ReusableMethods.bekle(2);
    }

}
