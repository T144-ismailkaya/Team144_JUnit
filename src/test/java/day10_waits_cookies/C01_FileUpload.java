package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class C01_FileUpload extends TestBaseEach {

    @Test
    public void test01(){
        //1. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2. chooseFile butonuna basalim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String dosyaYolu = "C:\\Users\\ismai\\IdeaProjects\\Team144_JUnit\\src\\test\\java\\day09_action\\sample.png";
        chooseFileButonu.sendKeys(dosyaYolu);
        //3. Yuklemek istediginiz dosyayi secelim.
        //4. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement gorunurTesti = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(gorunurTesti.isDisplayed());
    }

}
